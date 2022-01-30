//User function template for JAVA

/*Complete the Given Function

Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
    	data=d;
    	left=null;
    	right=null;
    }
}*/

//practice.geeksforgeeks.org/problems/transform-to-sum-tree/1/#

class Solution{
    public void toSumTree(Node root){
        int ans=toTree(root);
        
         //add code here.
         
    }
    public int toTree(Node root){
        int left=0;
        int right=0;
        
        if(root.left!=null){
             left=toTree(root.left);
         }
        if(root.right!=null){
             right=toTree(root.right);
        }
        int data=root.data;
        root.data=left+right;
        
        
        return data+root.data;
          
         
    }
}
