class Solution {
  //leetcode.com/problems/stone-game/submissions/
    
    public boolean stoneGame(int[] piles) {
        //O(n) space..
        
        int n=piles.length;
        
        int[] dp=new int[n];
        
        for(int i=0;i<n;i++){
            dp[i]=piles[i];
        }
        
        for(int d=1;d<n;d++){
            for(int i=0;i<n-d;i++){
                //i+d=j.
                
        dp[i]=Math.max(piles[i]-dp[i+1],piles[i+d]-dp[i]);
                
            //dp[i][j] means the biggest number of stones you can get more than opponent picking piles in piles[i] ~piles[j].
            // You can first pick piles[i] or piles[j].

            // If we pick piles[i], your result will be piles[i] - dp[i + 1][j]
            //bcoz if we pick piles[i],opponent will pick either (i+1) or jth..
            //dp[i+1][j] =means the biggest number of stones opponent can get more than me picking piles in piles[i+1] ~piles[j]...
            //if we reverse the statement..
            //i.e -dp[i+1][j]=means the biggest number of stones I can get more than oponent picking piles..from i+1 to j.
            // If we pick piles[j], your result will be piles[j] - dp[i][j - 1]
            }
        }
        
        return dp[0]>0;
        
        
        
    }
    
   
    
}
