class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int a=0;
        int b=0;
        for(int i=0;i<n;i++){
            int temp=Math.max(arr[i]+a,b);
            a=b;
            b=temp;
        }
        return b;
    }
}
