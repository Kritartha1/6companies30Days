class Solution {
    
    //Top sort: Kahn's algorithm
    //leetcode.com/problems/number-of-provinces/
  
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            g.add(new ArrayList<Integer>());
        }


        for (int i = 0; i < prerequisites.length; i++) {
            ArrayList<Integer> a = g.get(prerequisites[i][1]);

            a.add(prerequisites[i][0]);
            g.set(prerequisites[i][1], a);

        }
        return findTopOrdering(g,numCourses);
    }
    public int[] findTopOrdering( ArrayList<ArrayList<Integer>> g,int numCourses){
        int[] indeg=new int[numCourses];
        
        for(int i=0;i<numCourses;i++){
            for(int to:g.get(i)){
                indeg[to]++;
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int idx=0;
        
        int[] ordering=new int[numCourses];
        
        while (!q.isEmpty()){
            
            int temp=q.poll();
            ordering[idx++]=temp;
            
            for(int to:g.get(temp)){
                indeg[to]--;
                if(indeg[to]==0){
                    q.add(to);
                }
            }
        }
        if(idx!=numCourses){
            return new int[0];//returning an empty array
        }return ordering;
    }
}
