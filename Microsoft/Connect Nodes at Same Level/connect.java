//User function Template for Java

 /*
    Node class is Defined as follows:
    class Node{
        int data;
        Node left;
        Node right;
        Node nextRight;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
            nextRight = null;
        }
    }
    */
    
class Solution
{
    //Function to connect nodes at same level.
    public void connect(Node root)
    {
        //BFS or level order traversing
        
        // Your code goes here.
        if(root!=null){
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
          //queue will be like [root,null, ]
            while(!q.isEmpty()){
                Node curr=q.poll();
                if(curr==null){
                    return;//this case arises when there is only one node present ..
                    //then after doing q.poll() and implementing lines 178 and 179..
                    //there will be a null node present in queue..
                    //so in the next iteration we have to check for that null node
                }
                if(curr.left!=null){//at this step for the first loop...q looks like q=[null,root.left, ]
                    q.add(curr.left);
                }
                if(curr.right!=null){   //q=[null,root.left,root.right, ]
                    q.add(curr.right);
                }
                if(q.peek()==null){
                    curr.nextRight=q.poll();//q=[root.left,root.right, ]
                    q.add(null);//q=[root.left,root.right,null ]
                }else{
                    curr.nextRight=q.peek();
                }
            }
        }else{
            return ;
        }
        
        
    }
}
