class Solution {
    
    //leetcode.com/problems/pacific-atlantic-water-flow/
    boolean reachedAtlantic[][];//to check if Atlantic is reachable from a particular index
    boolean reachedPacific[][];//to check if Pacific is reachable from a particular index
    
    int n;
    int m;
    
    int[] row={-1,0,1,0};
    
    int[] col={0,1,0,-1};
   
    
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
       
        n=heights.length;
        m=heights[0].length;
        
        reachedAtlantic=new boolean[n][m];
        reachedPacific=new boolean[n][m];
        
        List<List<Integer>> res=new ArrayList<>() ;
        
        //iteration is started from base case..
        //i.e we start from the border of the height matrix..
        //and if it't neighbour is greater then the boundary height, then water can flow from the neighbour to the boundary...
        
        for(int i=0;i<n;i++){
            
              dfs(i,0,reachedPacific,heights);
              dfs(i,m-1, reachedAtlantic,heights);
            
        }
        
        for(int j=0;j<m;j++){
            
              dfs(0,j,reachedPacific,heights);
              dfs(n-1,j, reachedAtlantic,heights);
            
        }
        
        //if from a particluar index position,both the pacific and atlantic is reachable then add it to the list of answers...
        
        for(int i=0;i<n;i++){
            
            for(int j=0;j<m;j++){
                
                if(reachedAtlantic[i][j]&&reachedPacific[i][j]){
                    
                    ArrayList<Integer> temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                    res.add(temp);
                    
                }
            }
        }
         
      
        
        return res;
        
        
        
    }
     public boolean isValid(int r,int c,int[][] heights,boolean[][] reachableOcean,int parent){
       
        return (r>=0)&&(c>=0)&&(r<n)&&(c<m)&&(!reachableOcean[r][c])&&(heights[r][c]>=parent);
    }
    
    public void dfs(int i,int j,boolean[][] reachableOcean,int[][] heights){
        
        reachableOcean[i][j]=true;
        int parent=heights[i][j];
        
        for(int k=0;k<4;k++){
            
            int r=i+row[k];
            int c=j+col[k];
            
            if(isValid(r,c,heights,reachableOcean,parent)){
                dfs(r,c,reachableOcean,heights);
            }
            
        }
        
        
    }
    
   
    
}
