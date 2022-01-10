class Solution {
    boolean vis[][];
    
    boolean isValid(int r,int c,int m,int n,int[][] grid){
        return (r>=0&&c>=0&&r<m&&c<n&&!vis[r][c]&&grid[r][c]!=0);
    }
    
    public int orangesRotting(int[][] grid) {
        //Simple BFS
        
        int m=grid.length;
        int n=grid[0].length;
        vis=new boolean[m][n];
        
        
        Queue<Integer> qx=new LinkedList<>();
        Queue<Integer> qy=new LinkedList<>();

        int t=0;
        int freshOranges=0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    qx.add(i);
                    qy.add(j);
                    vis[i][j]=true;
                    
                }
                else if(grid[i][j]==1){
                    freshOranges++;//getting no. of fresh oranges
                }
            }
        }
        if(freshOranges==0){//if no freshOranges are there, smply return 0
            return 0;
        }
        int k=qx.size();
        
        int[] rr={-1,1,0,0};
        int[] cc={0,0,-1,1};
        //we have to do layer to layer bfs..
        //when 1st layer is rotten , we can move to the next layer to rot..and so on
        
        while(!qx.isEmpty()){
            ++t;
            k=qx.size();
            //k represents size of the current layer..
            //once we traverse through the layer, we can increase a minute
            while(k--!=0&&(!(qx.isEmpty()))){
                int r=qx.poll();
                
                int c=qy.poll();
                
                for(int i=0;i<4;i++)//4 directional traversal
                {
                     
                if(isValid(rr[i]+r,cc[i]+c,m,n,grid)){
                
                    freshOranges--;
                    grid[r+rr[i]][c+cc[i]]=2;
                    qx.add(rr[i]+r);
                    qy.add(cc[i]+c);
                    vis[r+rr[i]][c+cc[i]]=true;
                }
                    
                }
            }
            
        }
        
        
        return freshOranges==0?t-1:-1;
        
        //for eg: 2 1 1 
        //        1 1 0
        //        0 1 1
        //k=1
        
        //after 1st stage: 2 2 1
        //                 2 1 0
        //                 0 1 1
        //k=2
        
        //after 2nd stage: 2 2 2
        //                 2 2 0
        //                 0 1 1
        //k=2
        
        //after 1st stage: 2 2 2
        //                 2 2 0
        //                 0 2 1
        //k=1
        
        //after 1st stage: 2 2 2
        //                 2 2 0
        //                 0 2 2
        //k=1
        
        //so at the last stage when grid[2][2] element became 2 , it was also added to the queue unnecessarily..so the loop will run one more time..
        //so, we have to subtract 1 from the ans..
        
    }
    
}
