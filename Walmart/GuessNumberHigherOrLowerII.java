class Solution {
    //leetcode.com/problems/guess-number-higher-or-lower-ii/
    int[][] dp;
    int INT_MAX=Integer.MAX_VALUE;
    
    public int getMoneyAmount(int n) {
        dp=new int[n+1][n+1];
        
        for(int[] row:dp){
            Arrays.fill(row,INT_MAX);
        }
        
        for(int i=0;i<=n;i++){
            dp[i][i]=0;//if range of number is (i,i), then the number chosen must be correct..which is i..so we don't have to pay for this or pay 0$
        }
        
        solve(1,n,n);
        
        return dp[1][n];
        
        
        
    }
    
    public int solve(int i,int j,int n){
        //we are guessing a number in the range of i to j
        
            if(i>j){
                return -1;//obviously if i>j , then it's an invalid range..
            }
            
            else if(dp[i][j]!=INT_MAX){
                return dp[i][j];
            }
        
           
        //for number between i and j , take the best guess possible ..
        //the best guess will fetch the min ans we need...
        // and try to minimize the cost 
        
           for(int x=i;x<=j;x++){
               
               int temp= x+Math.max(solve(i,x-1,n),solve(x+1,j,n));
               dp[i][j]=Math.min(dp[i][j],temp);
           }
           
        
           
            
            return dp[i][j];
            
        
    }
    
}
