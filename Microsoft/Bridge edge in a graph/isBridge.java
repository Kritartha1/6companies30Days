class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        adj.get(c).remove(new Integer(d));
        adj.get(d).remove(new Integer(c));
        boolean vis[]=new boolean[V];
        Arrays.fill(vis,false);
        Queue<Integer> q=new LinkedList<>();
        q.add(c);
        vis[c]=true;//bfs done starting from vertex c
        while(!q.isEmpty()){
            int at=q.poll();
            for(int neighbours:adj.get(at)){
                if(!vis[neighbours]){
                    vis[neighbours]=true;
                    q.add(neighbours);
                }
            }
        }
        //if after bfs is done and we can't reach vertex d or vis[d]==false..
        //then there was a bridge between c and d..
        //so return 1..
        //else return 0
        return vis[d]?0:1;
        
    }
}
