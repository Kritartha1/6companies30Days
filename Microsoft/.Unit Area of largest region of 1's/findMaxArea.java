class Solution
{
    //Function to find unit area of the largest region of 1s.
  //Simple BFS
    
    public class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    
    int ans;
    int m;//rows
    int n;//columns
    boolean vis[][];//visited array
    
    //direction array to get immediate neighbours
    int[] row={-1,-1,0,1,1,1,0,-1};
    int[] col={0,1,1,1,0,-1,-1,-1};
    
    
    public int findMaxArea(int[][] grid)
    {
        // Code here
        ans=0;
        m=grid.length;
        n=grid[0].length;
        int Max=Integer.MIN_VALUE;
        
        vis=new boolean[m][n];
        for(boolean[] v:vis){
            Arrays.fill(v,false);
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isValid(i,j,grid)){
                    ans=0;
                    bfs(i,j,grid);
                    Max=Math.max(ans,Max);
                }
            }
        }
        return Max;
        
    }
    public boolean isValid(int r,int c,int[][] grid){
        return ((r>=0)&&(r<m)&&(c>=0)&&(c<n)&&(!vis[r][c])&&((grid[r][c])!=0));
    }
    
    
    public void bfs(int i,int j,int[][] grid){
        vis[i][j]=true;
        
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,j));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int x=curr.x;
            int y=curr.y;
            ans++;
            for(int k=0;k<8;k++){
                if(isValid(x+row[k],y+col[k],grid)){
                    q.add(new Pair(x+row[k],y+col[k]));
                    vis[x+row[k]][y+col[k]]=true;
                    
                    
                }
            }
            
            
        }
        
        
    }
}
