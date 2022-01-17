class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> ans=new ArrayList<>();
        int r=arr[n-1];
        for(int i=n-1;i>=0;i--){
            r=Math.max(r,arr[i]);
            if(r==arr[i]){
                ans.add(arr[i]);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
