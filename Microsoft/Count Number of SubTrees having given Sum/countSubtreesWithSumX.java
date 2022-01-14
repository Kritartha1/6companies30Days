class Tree
{
    int ans;
    //Function to count number of subtrees having sum equal to given sum.
    int countSubtreesWithSumX(Node root, int X)
    {
      //Add your code here.
      ans=0;
      SubtreeSum(root,X);
      return ans;
	
    }
    
    int SubtreeSum(Node root,int X){
        if(root==null){
            return 0;
        }
        int L=g(root.left,X);//checking for Sum X in left subtree
        
        int R=g(root.right,X);//checking for Sum X in right subtree
        
        int s=root.data+L+R;
        
        if(s==X){         //if leftsubtree+rightSubtree+ parent.data== reqd sum..then we got one of the answers..
        
            ++ans;
            
        }
        
        return s;
        //return the sum of the current subtree which can be used in the parent nodes calculation
    }
}

