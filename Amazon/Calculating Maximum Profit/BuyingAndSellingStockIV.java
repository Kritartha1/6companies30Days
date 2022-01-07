class Solution {
    static int maxProfit(int K, int N, int A[]) {
        
        // code here
        if(K>=(N/2)){
             //bcoz if k== atleast N/2..
            //bcoz max transactions can always n/2..
            //when case arises like:[1,3,2,6,5,9]..
            //the above case accounts for maxtransaction..
            //[1,3,4,5,6,2,9]
            //1->6 is one transaction..6-1=5.
            //2->9 is another transaction..9-2=7..
            //so when we buy on some j<ith day and sell on ith day and buy on the same day and then sell it on some other day..
            //then both (buying on some j<ith day(let say day t) ,selling on ith day)
            //and then (selling on j>ith(letsay mth day) day while buying on ith day) 
            //is same as buying on day t and selling on day m
            //so these two transaction compiled to make a single transaction..
            //so when selling(previous transaction) and buying day(next transaction) overlaps..
            //then total transaction will always be less than n/2..
            //i.e transactions decrease
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
