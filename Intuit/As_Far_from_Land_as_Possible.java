class Solution {
  
  //************************************************************************************************************************************************************************//
  // Qsn Link:---
  //leetcode.com/problems/as-far-from-land-as-possible/
  //************************************************************************************************************************************************************************//
    
//Intitution from discuss section :---
//The core intuition to use DP is if you can find a solution to a problem by combining the solutions to smaller sub-problems.
// Think about simpler DP problems like finding the shortest distance from (0,0) to (n,n) in a 2-D matrix where you can move either from left to right or top to bottom.
//The way you can move is constrained meaning you can reach a position (i,j) only from either (i-1,j) or (i,j-1). 
//This constraint makes it easy to apply the bottom-up DP technique here i.e., you start moving from top left to bottom right.

// We can apply the same logic as above to our current problem except the nearest land can not only be present in the top left portion of a water body, it can also be present in the bottom right portion. So we do the bottom up DP in 2-passes. Once from top left to bottom right and another from bottom right to top left and combine both. Hope this makes sense!
    
    
    public int maxDistance(int[][] grid) {
      
        int ans=-1;
        int n=grid.length;
        int m=grid[0].length;
        
        //in the below iterations.. *****grid will be changed to store the distances from nearest 1 to each zeroes.
        //if the grid needs to be kept intact,copy the grid into a different matrix and do operations on the new matrix..
        
        
        //Let's divide the problem into smaller subproblems..
        //to get to grid[i][j], we can either enter through (i-1,j) or (i,j-1) or (i+1,j) or (i,j+1)...
        //first we are iterating from the top left (0,0) to the bottom right (n-1,m-1)..
        //and checking for the path (i-1,j) and (i,j-1) for each (i,j)..if a shorter path from either of the mentioned indices exists...update the distance
       
        
        
       .
        
        for(int i=0;i<n;i++){
          
            for(int j=0;j<m;j++){
              
                if(grid[i][j]==1){
                    
                    //disance from (i,j) to (i,j) =0
                    //i.e if a grid[i][j]=1,then it's distance from nearest "1"(i.e itself ) is obviously 0..so value updated as 0...
                    
                    grid[i][j]=0;
                  
                    continue;
                }
              
                grid[i][j]=201;
                
                //there can be maximum 100 rows as per the constraints given..
                //so maximum manhattan dist <=2*100..
                //if there is no 1's in the grid, 201 will act as INT_MAX..
                //if we found after all the iterations are done, the we can say that there are no 1's ..so return -1
                
                if(i>0){//way from it's just above neighbour
                  
                    grid[i][j]=Math.min(grid[i-1][j]+1,grid[i][j]);
                  
                }
                
               
                if(j>0){ //way from it's just left neighbour
                  
                    grid[i][j]=Math.min(grid[i][j-1]+1,grid[i][j]);
                  
                }
            }
        }
        
        //now we are iterating from the   bottom right (n-1,m-1) to the top left (0,0)
        //and checking for the path (i+1,j) and (i,j+1) for each (i,j)..if a shorter path from either of the mentioned indices exists..update the distance
        .
        for(int i=n-1;i>=0;i--){
          
            for(int j=m-1;j>=0;j--){
                
                if(grid[i][j]==0){
                    continue;
                }
                
                if(i<n-1){//way from it's just below neighbour
                  
                    grid[i][j]=Math.min(grid[i+1][j]+1,grid[i][j]);
                  
                }
                if(j<m-1){//way from it's just right neighbour
                  
                    grid[i][j]=Math.min(grid[i][j+1]+1,grid[i][j]);
                  
                }
                
                ans=Math.max(ans,grid[i][j]);
            }
        }
        
        return ans==201?-1:ans;
        
        
    }
}
