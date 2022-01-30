//User function Template for Java

class Solution
{
    //Function to find total number of unique paths.
    //Bottom up approach ''space effiicient
    //practice.geeksforgeeks.org/problems/number-of-unique-paths5339/1/#
   
    public static int NumberOfPath(int a, int b) 
    {
        
        int[]dp=new int[b];
        dp[0]=1;
        
        for(int i=0;i<a;i++){
            for(int j=1;j<b;j++){
                dp[j]+=dp[j-1];
                //dp[i][j]=dp[i][j-1]+dp[i-1][j]
                //dp[i-1][j]=dp[j]..bcoz the this dp[j]will be of the previous loop..
                //so dp[i][j]=dp[j] is current loop j..
                //while dp[i-1][j] is previous loop j..which won't interfere in the calculations..
                //bcoz for the calculations we only need the final j i.e j=b-1...so the previous ones doesn't even matter..
                
            }
        }
        return dp[b-1];
        
        
    }
    
   
}
