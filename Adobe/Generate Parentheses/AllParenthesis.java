class Solution {
    
    Queue<Character> q;
    
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        
        String temp="(";
        
        q=new LinkedList<>();
        
        q.add(')');
        
        List<String> ans=new ArrayList<>();
        
        solve(temp,n,1,ans);
        
        return ans;
        
    }
    public void solve(String temp,int n,int size,List<String> ans){
        if(size==n){
            int N=q.size();
            
            while(N--!=0){
                temp+=')';
            }
            
            ans.add(new String(temp));
            return ;
        }
      
        
        if(q.peek()!=null){
            
            q.poll();
            
            solve(temp+')',n,size,ans);
            
            q.add(')');
            
        }
        
        
        q.add(')');
        
        solve(temp+'(',n,size+1,ans);
        
        q.poll();
            
            
        
        
    }
}
