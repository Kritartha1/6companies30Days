
class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    public static HashMap<Node,Node> parents;
    //parents stores the immediate parent node of the current node..
    //we need it bcoz, neighbours of a node are: left child, right child, parent..
    //we laready have left and right child..
    //so we have to get the parents!!!!
    
  //////////////////////////////////////////////
  //               SIMPLE BFS                 //
  //////////////////////////////////////////////
  
    public static int minTime(Node root, int target) 
    {
        // if(root==null){
        // //     return 0;
        // // }
        parents=new HashMap<>();
        
        Node Target=bfsFindParents(root,target);
        //it will find the target node as well as fill the parents map
        int minT=burn(Target);//
        // Your code goes here
        return minT;
        
        
    }
    public static Node bfsFindParents(Node root,int target){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        Node Target=new Node(-1);
        while(!q.isEmpty()){
            Node curr=q.poll();
            if(curr.data==target){
                Target=curr;//getting the target node
            }
            if(curr.left!=null){
                parents.put(curr.left,curr);//1st arg child,2nd arg parent
                q.add(curr.left);
            }
            if(curr.right!=null){
                parents.put(curr.right,curr);//1st arg child,2nd arg parent
                q.add(curr.right);
            }
        }
        return Target;
    }
    
    //in method burn ,bfs is done..
    //when all the neighbours are burnt, we increase time by 1/
    //when a layer of bfs is donw, if any of the neighbours gets burned,
    //we increase the time
    public static int burn(Node target){
        HashMap<Node,Integer> vis=new HashMap<>();
        vis.put(target,1);//to keep a check on the visited nodes
        Queue<Node> q=new LinkedList<>();
        q.add(target);
        int minT=0;
        
        while(!q.isEmpty()){
            int k=q.size();
            int t=0;
            
            while(k--!=0){
                Node temp=q.poll();
                if(temp.left!=null&&vis.get(temp.left)==null){
                    q.add(temp.left);
                    vis.put(temp.left,1);
                     t=1;
                }
                if(temp.right!=null&&vis.get(temp.right)==null){
                    q.add(temp.right);
                    vis.put(temp.right,1);
                    t=1;
                }
                if(parents.get(temp)!=null&&vis.get(parents.get(temp))==null){
                    q.add(parents.get(temp));
                    vis.put(parents.get(temp),1);
                    t=1;
                }
            }
            
            if(t==1){
                
                ++minT;
                 
            }
            
        }
        return minT;
        
    }
}
