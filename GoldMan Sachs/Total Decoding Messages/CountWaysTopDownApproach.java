class Solution
{
    int[] dp;
    public int CountWays(String str)
    {
        // code here
        int n=str.length();
        if(str.charAt(0)=='0'){
            return 0;
        }
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return ways(str,n);
        
    }
    public int ways(String str,int n){
        
        if(n==1||n==0){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        
        int temp1=0;
        int temp2=0;
        
        if(str.charAt(n-1)>'0'){
            temp1=ways(str,n-1);
        }
        if(str.charAt(n-2)=='1'||str.charAt(n-2)=='2'&&str.charAt(n-1)<'7'){
            temp2=ways(str,n-2);
        }
        return dp[n]=(temp1+temp2)%1000000007;
    }
}
