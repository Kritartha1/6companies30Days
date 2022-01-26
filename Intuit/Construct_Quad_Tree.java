/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

//************************************************************************************************************************************************************************//

//leetcode.com/problems/construct-quad-tree/

//************************************************************************************************************************************************************************//

class Solution {
  
    public Node construct(int[][] grid) {
        
        return quadTree(grid,0,0,grid.length);
        
    }
  
  
    //x,y is the top left corener of a square(consisting of >=1 boxes)
    //len is the dimanesion of the sq(len*len=area=a*a. a=len)
    public Node quadTree(int[][] grid,int x,int y,int len){
        if(len==1){
            return new Node(grid[x][y]==1,true);
        }
        
        Node root=new Node();//root of the quad tree..
        
        //recurse fot the four childrens/four quadrants...
        Node topLeft=quadTree(grid,x,y,len/2);
        Node topRight=quadTree(grid,x,y+len/2,len/2);
        Node bottomLeft=quadTree(grid,x+len/2,y,len/2);
        Node bottomRight=quadTree(grid,x+len/2,y+len/2,len/2);
        
        boolean value=topLeft.val;
        
        if(topLeft.isLeaf&& topRight.isLeaf && bottomLeft.isLeaf&& bottomRight.isLeaf
          &&value==topRight.val&&value==bottomLeft.val&&bottomLeft.val==value&&bottomRight.val==value){
            //if all the childrens have same value and all are leaf nodes,then the current node is a leaf node whose value will be same as it's children's val
            root.isLeaf=true;
            root.val=value;
            
        }else{
            
            root.topLeft = topLeft;
            root.topRight = topRight;
            root.bottomLeft = bottomLeft;
            root.bottomRight = bottomRight;
            
        }
        
        return root;
        
        
    }
}
