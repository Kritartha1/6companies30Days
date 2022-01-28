class Solution {
  //leetcode.com/problems/stone-game/
    int[][] dp;
  
    public boolean stoneGame(int[] piles) {
        
        int n=piles.length;
        dp=new int[n+1][n+1];
        
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        int Alice=solve(0,n-1,piles);
        
        int Bob=0;
        
//         for(int pile:piles){
//             Bob+=pile;
//         }
        
//         Bob-=Alice;
        
        Bob=Math.max(dp[1][n-1],dp[0][n-2]);//Since bob has 2nd turn..
        //so at first step..if alice picks up the first pile..
        //bob will have options to pick..from the 2nd pile to the last pile..(the end items ofc!)
        //if alice picks up the last pile..
        //bob will have options to pick..from the 1st pile to the 2nd last pile..(the end items obvio!!)
        
        
        if(Alice>=Bob){
            return true;
        }
        
        return false;
        
        
        
    }
    
    public int solve(int l,int r,int[] piles){
        
        if(l>r){
            
            return 0;
        }
        
        else if(dp[l][r]!=-1){
            return dp[l][r];
        }
        
        //at first step..alice will choose optimally ..so it will try to pick optimally i.e ,max stones piles..
        //while at Bob's turn he will also chooose optimally..
        
        //so Alice will be left out with the minimum options after bob has taken the maximum stones piles...
        int L=piles[l]+Math.min(solve(l+2,r,piles),solve(l+1,r-1,piles));
        int R=piles[r]+Math.min(solve(l+1,r-1,piles),solve(l,r-2,piles));
        
        dp[l][r]=Math.max(L,R);
        
        return dp[l][r];
    }
    
}
