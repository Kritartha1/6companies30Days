class Solution {
    
    Queue<Character> q;
    
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        //assumed that there n will be minimum 1
        
        String temp="(";//initializing the 1st character of each string
        
        List<String> ans=new ArrayList<>();
        
        int closingBrackets=1;//to keep a number of unclosed opening brackets
        int openingBrackets=1;//to keep a count of the used opening brackets
        
        solve(temp,n,openingBrackets,ans,closingBrackets);
        
        return ans;
        
    }
    public void solve(String temp,int n,int openingBrackets,List<String> ans,int closingBrackets){
        
        //if all the opening brackets are used..
        //so now just 
        if(openingBrackets==n){
            
            int N=closingBrackets;
            
            while(N--!=0){
                temp+=')';
            }
            
            ans.add(new String(temp));
            return ;
        }
        

        if(closingBrackets!=0){
            //means there are unclosed opening brackets still left..
            //so we can try to close them
          
            solve(temp+')',n,openingBrackets,ans,closingBrackets-1);
            
        }
        //just adding opening brackets to the string till all the opening brackets are used
        
        solve(temp+'(',n,openingBrackets+1,ans,closingBrackets+1);
        
         
    }
}
