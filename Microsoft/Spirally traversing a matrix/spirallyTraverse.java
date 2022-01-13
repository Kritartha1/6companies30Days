class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        int j=0;
        ArrayList<Integer> ans=new ArrayList<>();
        int R=c-1;
        int L=0;
        int D=r-1;
        int U=0;
        boolean right=true;
        boolean left=false;
        boolean down=false;
        boolean up=false;
        int n=r*c;//to keep a couter for the elements to iterate
        
        while(n>0){
            if(right){//if we take a right..iterate through all the valid elements of right
                for(int i=L;i<=R;i++){
                    ans.add(matrix[L][i]);
                    
                    n--;
                    
                }
                
                
                U++;//upper boundary will increase ..
                //if previous U=0..
                //after the iteration is done..we have alreasy processed the Upper layer..
                //so boundary comes down or U=U+1..
                
                right=false;//obviously now we can't move right
                down=true;//now we should move downwards
                
            }else if(down){
                for(int i=U;i<=D;i++){
                    ans.add(matrix[i][R]);
                    
                    --n;
                    
                }
                R--;
                left=true;
                down=false;
                
                
            }else if(left){
                for(int i=R;i>=L;i--){
                    ans.add(matrix[D][i]);
                    
                    --n;
                    
                }
                D--;
                up=true;
                left=false;
                
                
            }else{//up
                for(int i=D;i>=U;i--){
                    ans.add(matrix[i][L]);
                    
                    --n;
                    
                }
                L++;
                right=true;
                up=false;
                
            }
        }
        return ans;
    }
    
}
