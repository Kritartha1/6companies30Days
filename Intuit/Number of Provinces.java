class Solution {
    public Node[] nodes;
    class Node{
        int parent;
        int rank;
        Node(int parent,int rank){
            this.parent=parent;
            this.rank=rank;
        }
        
    }
  //leetcode.com/problems/number-of-provinces/
    
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        nodes=new Node[n];
        for(int i=0;i<n;i++){
            nodes[i]=new Node(-1,0);
        }
        
        int ans=NoOfConnectedComponents(isConnected,nodes);
        return ans;
        
    }
    public int NoOfConnectedComponents(int[][] isConnected,Node[] nodes){
        
        int n=isConnected.length;
        int components=n;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                //is checking for only the right side of the diagonal elements..
                //bcoz edge (1,2) is same as edge (2,1) in undirected graph..
                //so we are only checking the right side of the body diagonal of the 2D array
                if(isConnected[i][j]==1){//means node i and node j are connected
                    
                    int from=find(i);//node i
                    int to=find(j);//node j
                    if(to!=from){
                        union(from,to);
                        components--;//when two nodes are joined ..two components become 1..i.e components decreases by 1
                    }
                    
                }
            }
        }
        return components;
        
    }
    public int find(int v){
        if(nodes[v].parent==-1){
            return v;
        }return nodes[v].parent=find(nodes[v].parent);//path compression
    }
    public void union(int from ,int to){
        
        if(nodes[from].rank>nodes[to].rank){
            nodes[to].parent=from;
        }
        else if(nodes[from].rank<nodes[to].rank){
            nodes[from].parent=to;
        }
        else{
            nodes[from].parent=to;
            nodes[to].rank+=1;
        }
        
    }
}
