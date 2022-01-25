class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      //same qsn as : //leetcode.com/problems/split-array-largest-sum/solution/
        //leetcode.com/problems/koko-eating-bananas/submissions/
        int n=piles.length;
        int r=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            r=Math.max(piles[i],r);
        }
        int l=1;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(hours(piles,mid)<=h){
                ans=mid;
                r=mid-1;
                
            }else{
                l=mid+1;
            }
        }
        return ans;
        
    }
    public int hours(int[] piles, int X){
         int n=piles.length;
        int ans=0;
        
        for(int pile:piles){
            
                int q=(pile)/X;//for eg: k=X=4 and pile=12...so to eat the pile of 12 bananas, we need 12/4=3 hours...
                int r=pile%X;//if remainder is not 0 means there are some remaining bananas inthe pile...which can be eaten in the next hour..
                ans+=q+((r!=0)?1:0);
            
        }
        return ans;
    }
}
