class GfG
{
  static int[][] dp;
	public static int maxCoins(int A[],int n)
	{
          //add code here.
          dp=new int[n+1][n+1];
          for(int rows[]:dp){
              Arrays.fill(rows,-1);
          }
          solve(A,0,n-1);
          return dp[0][n-1];
          
    }
    static int solve(int A[],int l,int r){
        if(l>r){
            return 0;
        }
        else if(dp[l][r]!=-1){
            return dp[l][r];
        }
        int L=A[l]+Math.min(solve(A,l+2,r),solve(A,l+1,r-1)) ;
        //L=player X choose the lth index pot..
        //so player Y will take the max val of pots either of pot at l+1 index or rth index..
        //so, when player Y chooses the pot with max benefits..player X is left with min benefit pots..
        //for eg:if pot[l+1]>pot[r],then Y takes pot [l+1]..
        //so X will have the min value pot to select ..
        
        int R=A[r]+Math.min(solve(A,l+1,r-1),solve(A,l,r-2));
        //Similar condition if player X chooses the right most end index pot..
        dp[l][r]=Math.max(L,R);
        //why Math.min()?
        //bcoz when player Y will choose a pot, he will try to maximize his benefits..
        //so player X will have only one option left ..i.e to take the post with less benefits..
        //
        return dp[l][r];
        
    }
}
