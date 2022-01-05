class Solution {
    public boolean canPair(int[] nums, int k) {
       
        if (nums.length % 2!=0)
            return false;
 
        HashMap<Integer, Integer> mp = new HashMap<>();
 
        // Count occurrences of all remainders
        for (int i = 0; i < nums.length; i++) {
            int r = (nums[i] % k);
            
            mp.put(r, mp.getOrDefault(r,0) + 1);
        }
 
        for (int i = 0; i < nums.length; i++) {
            
            int r2= (nums[i] % k);
 
            if (2 * r2 == k) {
                
                if (mp.get(r2) % 2 == 1)
                    return false;
            }
 
            else if (r2 == 0) {
                
                if (mp.get(r2) % 2 == 1)
                    return false;
            }
 
            else {
                if (mp.get(k - r2) != mp.get(r2))
                    return false;
            }
        }
        return true;
    }
}
