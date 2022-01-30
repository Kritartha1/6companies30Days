class Solution {
  //practice.geeksforgeeks.org/problems/sorted-subsequence-of-size-3/1/#

    ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
        // add code here.
        ArrayList<Integer> ans=new ArrayList<>();
        
        int[] l=new int[n];//l[i]:stores the minimum value to the left of arr[i].. 
        
        l[0]=arr.get(0);
        
        for(int i=1;i<n;i++){
            l[i]=Math.min(l[i-1],arr.get(i-1));
        }
        
        int max=arr.get(n-1);
        
        for(int i=n-2;i>=1;i--){
            int curr=arr.get(i);
            if(max>curr&&curr>l[i]){
                ans.add(l[i]);
                ans.add(curr);
                ans.add(max);
                return ans;
            }
            max=Math.max(max,curr);
        }
        
        return ans;
    }
}
