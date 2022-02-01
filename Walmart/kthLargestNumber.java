//leetcode.com/problems/find-the-kth-largest-integer-in-the-array/
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        
        PriorityQueue<String> pq=new PriorityQueue<>((s1,s2)->{
            if(s1.length()==s2.length()){
                return s1.compareTo(s2);
            }
            return s1.length()-s2.length();
        });
        
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
            
        }
        
        return pq.poll();
        
    }
}
