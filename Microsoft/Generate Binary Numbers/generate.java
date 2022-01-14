class solve{
    
    //Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int N)
    {
        // Your code here
        ArrayList<String> ans=new ArrayList<>();
        
        for(int i=1;i<=N;i++){
            String temp="";
            int x=i;
            while(x!=0){
                temp=(x%2)+temp;
                
                x=x/2;
                
            }
            ans.add(temp);
        }
        return ans;
    }
    
}
