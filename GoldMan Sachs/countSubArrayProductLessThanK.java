class Solution {
    
    public int countSubArrayProductLessThanK(long a[], long n, long k)
    {
        int i=0;//i is the index which multiplies the elements iteratively or closing index window
        int j=0;//j is the starting index of the window
        int ans=0;
        long curr=1;
        while(i<n){
            curr*=a[i];
           while(j<i&&curr>=k){//resizing the window
               curr/=a[j++];
           }
           if(curr<k){
               ans+=i-j+1;//
           }
           i++;
        }
        return ans;
    }
}
