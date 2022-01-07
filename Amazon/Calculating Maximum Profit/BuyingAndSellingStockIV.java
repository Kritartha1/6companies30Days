class Solution {
    static int maxProfit(int K, int N, int A[]) {
        
        // code here
        if(K>=(N/2)){
            int maxProfit=0;
            for(int i=1;i<N;i++){
                if(A[i]>A[i-1]){
                    maxProfit+=A[i]-A[i-1];
                }
            }
            return maxProfit;
        }
        int[][] dp=new int[K+1][N];
      //dp[0][] means atmost 0 transactions....then profit will obviously be 0
      //dp[][0] means profit at day 0..which will obviously be 0
        for(int i=1;i<=K;i++){
            int tempMax=dp[i-1][0]-A[0];//i.e buying at day 1
          //tempMax variable will be keeping the previous max transaction details ..
            for(int j=1;j<N;j++){
                dp[i][j]=Math.max(dp[i][j-1],A[j]+tempMax);
                //dp[i][j-1]=skipping jth day and getting maxProfit from the previous (j-1)days using atmost i transactions
                //A[j]+tempMax=selling at jth day and doing atmost ith transaction
                tempMax=Math.max(tempMax,dp[i-1][j]-A[j]);//will be helpful for the next iteration of j..
                //when j will be j+1
                //means max of (doing atmost (i-1)th transaction and buying at day(j)) 
                //i.e for the next iteration of j, tempMax will be doing atmost (i-1) transaction till a day ranging day 0 to day j..and buying at jth day
            }
        }
        return dp[K][N-1];
    }
}
