class Solution
{
  //practice.geeksforgeeks.org/problems/number-of-unique-paths5339/1/#
  //Top down approach
  
    //Function to find total number of unique paths.
    static int ans=0;
    static int m;
    static int n;
    static int[][] dp;
  
    public static int NumberOfPath(int a, int b) 
    {
        //Your code here
        m=a;
        n=b;
        dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return dfs(0,0);
        
        
    }
    
    public static int dfs(int i,int j){
        
        if(i==m-1||j==n-1){
            return 1;
            
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        dp[i][j]=dfs(i+1,j)+dfs(i,j+1);
        return dp[i][j];
        
        
    }
}
