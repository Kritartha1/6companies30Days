//qsn link:
//leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/
//greedy approach
class Solution {
    
    
    //clear explanation:
    //leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/discuss/768076/Min-Adjacent-Swaps-to-Sort-the-array-of-INTEGERS-with-Proof
    //***************************************************************************//
    public int minSwaps(int[][] grid) {
        
        int n=grid.length;
        
        int a[]=new int[n];//will store the trailing zeroes ...
        
        findTrailingZeros(a,grid,n);
        
        return findAns(a,n);
        
    }
    //***************************************************************************//
    private int findAns(int[] a,int n){
        
        int ans=0;
        
        for(int i=0;i<n;i++){
            
            if(a[i]<n-i-1){
                
                int j=i;
                
                while(j<n&&a[j]<n-i-1){
                    j++;
                }
                
                if(j==n){
                    
                    return -1;
                    //didn't find any a[j]>=n-i-1..so it's not possible to make the grid valid....
                }
                
                while(j>i){
                    
                    swap(j,j-1,a);
                    ++ans;
                    --j;
                    
                }
            }
        }
        return ans;
        
    }
    //***************************************************************************//
    private void findTrailingZeros(int[] a,int[][] grid,int n){
        for(int i=0;i<n;i++){
            
            int temp=0;
            
            for(int j=n-1;j>=0;j--){
                
                if(grid[i][j]==1){
                    
                    break;
                }
                
                temp++;
            }
            
            a[i]=temp;
        }
    }
    
    //***************************************************************************//
    private void swap(int i,int j,int[] a){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    //***************************************************************************//
}
