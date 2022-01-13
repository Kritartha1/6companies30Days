class GFG
{
    static void rotate(int matrix[][]) 
    {
        // Code Here
        int n=matrix.length;
        
        //first doing transpose..
        for(int i=0;i<n;i++){
            for(int j=i;j<matrix[0].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //after transpose..if we swap the matrix wrt to the horizontal n/2 posn..we get our reqd matrix
        for(int i=0;i<=(n-1)/2;i++){
            for(int j=0;j<matrix[0].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-i-1][j];
                matrix[n-i-1][j]=temp;
            }
        }
        
    }
}
