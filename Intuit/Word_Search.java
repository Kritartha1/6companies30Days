class Solution

{//Simple dfs  
  //practice.geeksforgeeks.org/problems/word-search/1/#
    
    int m;
    int n;
    int N;
    int[] row={-1,1,0,0};
    int[] col={0,0,-1,1};
    
    
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        N=word.length();
        char start=word.charAt(0);
        m=board.length;
        n=board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==start){
                    String temp="";
                    if(dfs(board,word,new boolean[m][n],0,i,j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean isValid(char[][] board,boolean[][]vis,int r,int c){
        return (r>=0)&&(c>=0)&&(r<m)&&(c<n)&&(!vis[r][c]);
        
    }
    
    public boolean dfs(char board[][],String word,boolean[][]vis,int k,int i,int j){
        vis[i][j]=true;
        k++;
        if(k==N){
            return true;
        }
        for(int t=0;t<4;t++){
            int r=i+row[t];
            int c=j+col[t];
            if(isValid(board,vis,r,c) &&board[r][c]==word.charAt(k)){
                if(dfs(board,word,vis,k,r,c)){
                    return true;
                }
            }
        }
        
        return false;
    }
}
