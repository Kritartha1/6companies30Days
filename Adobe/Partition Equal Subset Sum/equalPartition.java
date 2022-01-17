class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum=0;
        
        for(int a:arr){
         sum+=a;   
        }
        
        //if total sum is odd..then can't divide into equal halves
        //else just check for half of the total sum..
        //if that's present then the other half will be also present
        if((sum&1)==0){
            int M=sum/2;
            boolean[][] dp=new boolean[N+1][M+1];
            for(int i=0;i<N+1;i++){
                for(int j=0; j<M+1;j++){
                    if(i==0){
                        dp[i][j]=false;
                    }else if(j==0){
                        dp[i][j]=true;
                    }else if(arr[i-1]<=j){
                        dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
                    }else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
            
            return dp[N][M]?1:0;
        }else{
            return 0;
        }
        
    }
}
