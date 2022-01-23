class Solution {
    
    //to get a better explanation ,check leetcode solution..
    //leetcode.com/problems/split-array-largest-sum/solution/
    
    public int splitArray(int[] nums, int m) {
        
        long l=Integer.MIN_VALUE;
        long r=0;
        long ans=0;
        
        for(int num:nums){
            l=Math.max(l,num);
            r+=num;
            
        }
        //if we split each element of the array, the we will get the least max subarray sum which is equal to the maxElement of the array..
        //and maximum of max subarray sum =sum(nums)..which is ofcourse the maximum possible subarray sum..as when there is no split...the subarray is the array itself ..
        
        //So, now , we got our lower boundary for the subarray sum which is l=max(nums[i])
        //and we got the upper boundary ..which is r=sum(nums[i])
        
        //we can do binary search in such a situation and look for each possible least max sum available..
        
        
        while(l<=r){
            
            long mid=l+((r-l)/2);
            
            if(minSubArraysRequired(nums,mid)<=m){
                // The key observation here is that if we are able to split the array into mm or fewer subarrays for a value X then we will also be able to do it for any value greater than X. This is because the number of subarrays would be even less in case of any value greater than X. Similarly, if it's not possible for a value X it will not be possible to have m or fewer splits for any value less than X.
                // Therefore, instead of searching linearly for X, we can do a binary search! If we can split the array into mm or fewer subarrays all with a sum that is less than or equal to X then we will try a smaller value for X otherwise we will try a larger value for X. Each time we will select X so that we reduce the size of the search space by half.
               r=mid-1;
               ans=mid;
                
            }
            else{
                
                l=mid+1;
                
            }
        }
        
        return (int)ans;
        
    }
    public int minSubArraysRequired(int[] nums,long mid){
        
        int minSplit=0;
        long currSum=0;
        
        for(int num:nums){
            
            currSum+=num;
            
            if(currSum>mid){
                currSum=num;
                 minSplit++;
            }
            
        }
        
        return minSplit+1;
        
    }
}
