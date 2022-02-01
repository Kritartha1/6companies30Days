class Solution {
    //leetcode.com/problems/find-array-given-subset-sums/
    //for explanation refer to discussion :
        //https://leetcode.com/problems/find-array-given-subset-sums/discuss/1421426/Java-Short-and-Best-Solution-O(NLogN)-N2n-with-explanation-(41-ms-beats-100)
    
    public int[] recoverArray(int n, int[] sums) {
        
        Arrays.sort(sums);
        
        int[] ans=new int[n];
        
        
        int m=sums.length;
        
        int[] l=new int[m/2];
        int[] r=new int[m/2];
        
        //Intitution: the absolute difference the smallest subset sum and second smallest subset sum will give one of the original number ..let say x..but we won't get the sign of the number..
        //to get the sign of the number we have to set a flag of containing 0 or not zero in the left array 
        //bcoz recursilvely if we do it..
        //we divide the subarray into two groups : left and right..
        //left: {a1,a2,...}  right: {a1+x,a2+x.....}
        //if right half contains zero, then x must be negative..
        //if left half contains the zero (or empty set) then x must be positive..
        
        //for more explanation refer to discussion :
        //https://leetcode.com/problems/find-array-given-subset-sums/discuss/1421426/Java-Short-and-Best-Solution-O(NLogN)-N2n-with-explanation-(41-ms-beats-100)
        for(int i=0;i<n;i++){
            
            int diff=sums[1]-sums[0];
            boolean containsZero=false;
            int p=-1,q=-1,k=0;
            for(int j=0;j<m;j++){
                if(k<=q&&r[k]==sums[j]){
                    ++k;
                }
                else{
                    if(sums[j]==0){
                        containsZero=true;
                    }
                    l[++p]=sums[j];
                    r[++q]=sums[j]+diff;
                }
            }
            if(containsZero){
                ans[i]=diff;
                sums=l;
            }else{
                ans[i]=-diff;
                sums=r;
            }
            m=m>>1;
        }
        
        return ans;
        
    }
}
