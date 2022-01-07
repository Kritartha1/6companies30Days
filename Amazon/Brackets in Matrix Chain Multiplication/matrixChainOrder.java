class Solution{
    //for more insights..
    //check :https://youtu.be/kMK148J9qEE   (Aditya Verma)
    //check :https://www.youtube.com/watch?v=prx1psByp7U   (Abdul Bari)
    //check :https://youtu.be/eKkXU3uu2zk   (Abdul Bari)
    static long[][] dp;
    static int[][] S;
    static char c;
    static String ans;
    //dp[1][2] ,means min cost of multiplying matrix 1 and matrix 2..
    //dp[1][3] means min cost of multiplying matrix1 * matrix 2 * matrix 3.
    //dp[2][3] means min cost of multiplying matrix 2 * matrix 3
    //dp[3][3] means the self matrix matrix itself..so 0 cost..since no multiplication
    //dp[0][]=0..doesn't have any meaning
    //dp[][0]= 0..doesn't have any meaning
    static String matrixChainOrder(int p[], int n){
        // code here
        int matrices=n-1;
        
        dp=new long[n+1][n+1];
        S=new int[n+1][n+1];
        for(long[] row:dp){
            Arrays.fill(row,-1);
        }
        for(int[] row: S){
            Arrays.fill(row,0);
        }
        solve(p,1,n-1);
        ans="";
        c='A';
        printString(1,n-1);
        return ans;
        
        
    }
    static long solve(int[] p,int i,int j){
        if(i>=j){
            return 0l;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        long min=Long.MAX_VALUE;
        for(int k=i;k<j;k++){
            long tempAns=solve(p,i,k)+solve(p,k+1,j)+p[i-1]*p[k]*p[j];
            
            if(tempAns<min){
                min=tempAns;
                S[i][j]=k;//will store the partition point..
                //S[i][j]=k means (i,k)(k+1,j) partitions..
            }
        }
        return dp[i][j]=min;
    }
    static void printString(int i,int j){
        if(i==j){//if only one element left ..then just return the element..
             ans+=(c);
             c++;
             return;
        }
        //else..
        ans+="(";
        printString(i,S[i][j]);//printing parenthesis till k=S[i][j]
        printString(S[i][j]+1,j);//printing parenthesis from k+1 to j
        ans+=")";
        
        
    }
}
