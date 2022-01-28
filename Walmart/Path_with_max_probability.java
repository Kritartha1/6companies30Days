class Solution {
//leetcode.com/problems/path-with-maximum-probability/submissions/    
    public class Pair{
        int idx;
        double prob;
        Pair(int idx,double prob){
            this.idx=idx;
            this.prob=prob;
        }
    }
    
    //Using Dijkstra's algorithm
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        Map<Integer,ArrayList<double[]>> mp=new HashMap<>();
        //Integer will keep the "from" vertex..
        //Double[0] will store "to" vertex
        //double[1] will store succProb(edge from-to);
        
        for(int i=0;i<edges.length;i++){
            
            int[] edge=edges[i];
            //edge[0]=from
            //edge[1]=to
            
            mp.putIfAbsent(edge[0],new ArrayList<>());
            mp.putIfAbsent(edge[1],new ArrayList<>());
            
            mp.get(edge[0]).add(new double[]{edge[1],succProb[i]});
            mp.get(edge[1]).add(new double[]{edge[0],succProb[i]});
            
        }
        
        double probabs[]=new double[n];//it stores the min Probability from node start to any nodes
        
        probabs[start]=1;
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->(((Double)b.prob).compareTo((Double)a.prob)));
        
        //probability in descending  order
        
        pq.add(new Pair(start,1d));
        
        while(!pq.isEmpty()){
            
            Pair curr=pq.poll();
            
            int idx=curr.idx;
            double prob=curr.prob;
            
            if(idx==end)
            {//if we have reached the reqd node..then return its probability of success
                
                return prob;
            }
            
            for(double[] childs:mp.getOrDefault(idx,new ArrayList<>())){
                
                int to=(int)childs[0];
                
                double succProbability=childs[1];//=succProb(edge idx-->edge to)
                
                if(probabs[to]<prob*succProbability){//
                
                    pq.add(new Pair(to,prob*succProbability));
                    
                    probabs[to]=prob*succProbability;
                }
            }
        }
        
        return 0d;
        
    }
}
