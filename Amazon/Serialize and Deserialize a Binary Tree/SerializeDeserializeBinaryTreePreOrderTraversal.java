/*Complete the given function
Node is as follows:
class Tree{
	int data;
	Tree left,right;
	Tree(int d){
		data=d;
		left=right=null;
	}
}*/

class Tree 
{
    int k=0;
    //By doing pre order traveral it will be easier to deserialize
    //Function to serialize a tree and return a list containing nodes of tree.
	public void serialize(Node root, ArrayList<Integer> A) 
	{
	    //storing the tree as preorder traversal
	    //empty children's are termed as '-1'
	   
	    if(root!=null){
	    A.add(root.data);
	        
	    }else{
	        A.add(-1);
	        return;
	        
	    }
	    serialize(root.left,A);
	    serialize(root.right,A);
	    
	}
	
	
	//Function to deserialize a list and construct the tree.
	int i=0;
    public Node deSerialize(ArrayList<Integer> A)
    {
       if(A.get(i)!=-1){//means node is not null
       //so we can check it's right or left children
       //if node is at ith index, it's left child will be at (i+1) th index..
       //right children will be some k index after ith index when left children is fully traversed
       
           Node root=new Node(A.get(i++));
           root.left=deSerialize(A);
           root.right=deSerialize(A);
           return root;
       }else{
           i++;
           //if left child is null,there may be a right child...
           //or if right child is null,there may be a left child...
           //so incrementing i to get right/left child..
           //and the -1 child is a null node..
           //so returning null for that node
           return null;
       }
       
    }
    
};
