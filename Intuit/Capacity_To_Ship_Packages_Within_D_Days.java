class Solution {
    public int shipWithinDays(int[] weights, int days) {
      
        //leetcode.com/problems/capacity-to-ship-packages-within-d-days/
      
        //same qsn as:
        //leetcode.com/problems/split-array-largest-sum/solution/
        //check explanation there...
        
        int l=Integer.MIN_VALUE;
        int r=0;
        
        for(int weight:weights){
            r+=weight;
            l=Math.max(l,weight);
        }
        
        int ans=-1;
        
        while(l<=r){
            int mid=l+(r-l)/2;
            if(minPartition(weights,mid)<=days){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        
        return ans;
        
    }
    
    public int minPartition(int[] weights,int X){
        
        int currSum=0;
        int count=0;
        
        for(int weight:weights){
            currSum+=weight;
            if(currSum>X){
                currSum=weight;
                count++;
                
            }
        }
        
        return count+1;
        
        
    }
}
