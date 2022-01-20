class Solution {
    static int minInsAndDel(int[] A, int[] B, int N, int M) {
        // code here
        Set<Integer> s=new HashSet<>();
        List<Integer> a=new ArrayList<>();
        for(int i=0;i<M;i++){
            s.add(B[i]);
        }
        
        for(int i=0;i<N;i++){
            if(s.contains(A[i])){
                a.add(A[i]);
            }
        }
        //first all the elements of array A which are also present in B are stored in a list..
        //then we will find LIS(longest increasing subsequence )from the list of elements..
        //which will give insertions and deletions..
        //number of deletions=N-LIS
        //number of inserions=M-LIS..
        //so total operations =N+M-2*LIS..
        
        int LIS_LCS=solve(a.stream().mapToInt(i -> i).toArray());
        //this will convert the list to primitive int[] array..
        
        return (M+N-2*LIS_LCS);
    }
    
    
    static int solve(int[] arr){
        int n=arr.length;
        if(n==0){
            return 0;
        }
        
        int[] lis=new int[n];
        lis[0]=arr[0];
        int size=1;
        
        for(int i=0;i<n;i++){
            
            if(arr[i]>lis[size-1]){
                lis[size++]=arr[i];
            }
            else{
                int idx=Arrays.binarySearch(lis,0,size-1,arr[i]);
                //.binarySearch is similar as lowerbound in cpp..
                //if arr[i] is found between index 0 and index size-1,
                //then it will return that index .
                //if no index found, then it will return the index which is just greater than the given element..
                //but with little modification..
                //if no element found..
                //let k=(index of element just greater than the given element))
                //it will return = (-k)-1..
                //so after doing binary search..to get k, we will have to take the absolute value of idx..
                //which is (k+1)..
                //and then substact 1 from it..(k+1)-1=k=Math.abs(-k-1)-1;
                if(idx<0){
                    idx=Math.abs(idx)-1;
                }
                lis[idx]=arr[i];
            }
        }
        return size;
    }
};
