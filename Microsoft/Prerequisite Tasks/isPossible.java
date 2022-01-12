class Solution {
    ArrayList<ArrayList<Integer>> graph;
    public boolean isPossible(int N, int[][] prerequisites)
    {
        // Your Code goes here
        makeGraph(prerequisites,N);
        return topSort(N);//Simple Kahn's sort algo..
        
    }
    public void makeGraph(int[][] prerequisites,int N){
        graph=new ArrayList<>();
        for(int i=0;i<N;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pair:prerequisites){
            int to=pair[0];
            int from=pair[1];
            graph.get(from).add(to);
        }
    }
    
    public boolean topSort(int N){
        int[] indeg=new int[N];
        for(int i=0;i<N;i++){
            for(int to:graph.get(i)){
                indeg[to]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<N;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int idx=0;
        while(!q.isEmpty()){
            int at=q.poll();
            idx++;
            for(int to:graph.get(at)){
                indeg[to]--;
                if(indeg[to]==0){
                    q.add(to);
                }
            }
        }
        if(idx!=N){
            //means a cycle present ..so all courses can't be taken..
            return false;
        }return true;
    }
    
}
