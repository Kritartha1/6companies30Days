class Solution {
    int lengthOfLongestAP(int[] A, int n) {
        // code here
       
        
        if(n>2){
            int maxCommonDiff=A[n-1]-A[0];//since array is sorted ..so max cd can be the diff of the last and the first term.
            int[][] dp=new int[1001][maxCommonDiff+1];
            int ans=2;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    int cd=A[j]-A[i];
                    dp[j][cd]=Math.max(dp[i][cd]+1,2);
                    //2 is taken bcoz, two elements  always constitute an AP..so min length will always be 2
                    
                    //dp[j][cd]=AP ending at element at ith index with cd=A[j]-A[i]..
                    //which will immediately check the length till previous element..
                    //when A[j] was added, length of the AP where cd=A[j]-A[i] and previous element  A[i] is increased by 1
                    //dp[i][cd]=AP which ending  element is element at ith index with cd =A[j]-A[i]..
                    ans=Math.max(dp[j][cd],ans);
                    
                    
                }
            }
            return ans;
            
        }else{
            //if n==1 or n==2 ,we know a single element is always an Ap..
            //or any two elements always constitute an AP..
            return n;
        }
    }
}
