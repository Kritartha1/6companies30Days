class Solution {
  //leetcode.com/problems/maximum-performance-of-a-team/
  
  
//     Performance = sum(speed) * min(efficiency). Idea is simple: try every efficiency value from highest to lowest and at the same time maintain an as-large-as-possible speed group, keep adding speed to total speed, if size of engineers group exceeds K, lay off the engineer with lowest speed.

// Sort efficiency with descending order. Because, afterwards, when we iterate whole engineers, every round, when calculating the current performance, minimum efficiency is the effiency of the new incoming engineer.
// Maintain a pq to track of the minimum speed in the group. If size of group is == K, kick the engineer with minimum speed out (since efficiency is fixed by new coming engineer, the only thing matters now is sum of speed).
// Calculate/Update performance.

    long mod=(long)1e9+7;
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        int[][] eff_speed=new int[n][2];
        
        for(int i=0;i<n;i++){
            eff_speed[i]=new int[]{efficiency[i],speed[i]};
            
        }
        
        Arrays.sort(eff_speed,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return b[0]-a[0];
            }
        });
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();//minheap
        long currSum=0;
        long ans=0;
        
        for(int[] pair:eff_speed){
            
            pq.add(pair[1]);
            currSum+=pair[1];
            
            if(pq.size()>k){
                currSum-=pq.poll();//the engineer with the min speed is laid off..
              //bcoz eventually the more speed matters and the latest engineer efficiency(i.e lowest efficiency ) matters..
              //previous value from the priority queue won't create any hindrance
            }
            
            ans=Math.max(ans,currSum*pair[0]);
            //doubt clarification:
            //if the polled pair is the currently added pair, why pair[0] was multiplied..
            //Ans: boz, if current pair is polled  currSum*pair[0] will be always less tha or ewual to the previous max ans..so it won't interfere in the result.. 
        }
        
        return (int)(ans%mod);
        
        
    }
    
    
}
