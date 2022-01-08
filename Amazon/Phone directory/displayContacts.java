
class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {   
        // code here
        //ans should have distinct contacts with lexographically increasing order..
        //so we first sort the contact array..
        //then get all the distinct elements into an arraylist..
        int m=s.length();
        Arrays.sort(contact);
        ArrayList<String> distinctString=new ArrayList<>();
        int k=0;
        while(k<n-1){
            if(contact[k].equals(contact[k+1])){
                while(k<n-1&&contact[k].equals(contact[k+1])){
                    k++;
                }
            }else{
                distinctString.add(contact[k++]);
                
            }
        }
        distinctString.add(contact[k]);
        //instead of doing the previous steps..
        ///we could gave simply stored the contacts in a TreeSet..
        //bcoz treeset will allow only the distinct contacts and in lexographically order
        //TreeSet<String> distinctString=new TreeSet<>();
        //for(String S: contact)
        // {
        //      distinctString.add(S);
        // }
        
        n=distinctString.size();
         ArrayList<ArrayList<String>> ans=new ArrayList<>(m);
         for(int i=0;i<m;i++){
             ans.add(new ArrayList<>());
         }
         
         
         for(int i=0;i<n;i++){
             //for each distinct element we are running each queries from 1 to |s|
             int j=0;
             boolean t=true;
             //it handles the case when the prefix becomes different for the first time..
             //initially t is set to true..so that the loop starts atleast..
             int L=distinctString.get(i).length();
             //for a string P, it's query can be of max(|s|,P.length()) only..
             ///bcoz if |s|>|P|..then after index=|s|..it is unncessary to check for prefix..
             //since after that index there can't be any query..
             
             for(;j<L&&j<m;j++){
                 if(t&&s.charAt(j)==distinctString.get(i).charAt(j)){
                     ArrayList<String> temp=ans.get(j);
                     temp.add(distinctString.get(i));
                     t=true;
                 }else{
                     t=false;
                     break;
                 }
             }
         }
         for(ArrayList<String> temp:ans){
             //if any query has no distinct contacts available..then printing 0
         
             if(temp.size()==0){
                 temp.add("0");
             }
         }
         return ans;
    }
}
