class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int n=nums.length;
        int s=0;
        while(j<n){
            s+=nums[j];
            if(s>=target){
             
                while(i<=j&&s>=target){
                    min=Math.min(j-i+1,min);//bcoz after deleting elements from ith index or starting index, we can still get our required result at midway..
                    s-=nums[i++];
                }
            }
            j++;
            
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
