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


//clean code:
class Solution
{
    public int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
    public boolean isWordExist(char[][] board, String word)
    {
        
        int m=board.length;
        int n=board[0].length;
        // Code here
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)&&dfs(board,i,j,word,new boolean[m][n],0)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean isValid(char[][] board,int r,int c,boolean[][] vis){
        return r>=0&&c>=0&&r<board.length&&c<board[0].length&&!vis[r][c];
    }
    boolean dfs(char[][] board,int i,int j,String word,boolean[][] vis,int idx){
        if(idx==word.length()){
            return true;
        }
        if(word.charAt(idx)!=board[i][j]){
            return false;
        }
        vis[i][j]=true;

        for(int k=0;k<4;k++){
            int r=i+dir[k][0];
            int c=j+dir[k][1];
            if(isValid(board,r,c,vis)&&dfs(board,r,c,word,vis,idx+1)){
                return true;
            }
        }
        return false;
    }
    
}
