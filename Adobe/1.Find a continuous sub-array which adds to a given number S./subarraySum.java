class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        //sliding window method
        int sum=0;
        int i=0,j=0;
        ArrayList<Integer> ans=new ArrayList<>();
        
        while(j<n){
            sum+=arr[j];
            if(sum>s){
                while(sum>s&&i<j){
                    sum-=arr[i++];
                    
                }
            }
            if(sum==s){
                ans.add(i+1);
                
                ans.add(j+1);
                return ans;
               
            }
            ++j;
        }
        ans.add(-1);
        return ans;
    }
}
