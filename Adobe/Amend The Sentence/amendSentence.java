class Solution{
    public String amendSentence(String s){
        //code here
        char[] k=s.toCharArray();
        k[0]=Character.toLowerCase(k[0]);
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++){
          
            if(k[i]<='Z'&&k[i]>='A'){
                ans.append(" ");
                k[i]=Character.toLowerCase(k[i]);
                
            }
            ans.append(k[i]);
        }
        
        return ans.toString();
        
    }
}

