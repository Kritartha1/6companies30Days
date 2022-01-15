class Solution
{
    //Question similar to prerequisites course 
    
    HashMap<Character,Integer> indeg;
    HashMap<Character,ArrayList<Character>> adj;
    
    public String findOrder(String [] dict, int N, int K)
    {
        adj=new HashMap<>();
        indeg=new HashMap<>();
        buildGraph(dict,N,K);
        // Write your code here
        PriorityQueue<Character> pq=new PriorityQueue<>();
        for(char k: indeg.keySet()){
            if(indeg.get(k)==0){
                pq.add(k);
            }
        }
        int idx=0;
        String ans="";
        
        while(!pq.isEmpty()){
            char at=pq.poll();
            ans+=at;
            
            idx++;
            for(char to:adj.getOrDefault(at,new ArrayList<Character>())){
                indeg.put(to,indeg.get(to)-1);
                if(indeg.get(to)==0){
                    pq.add(to);
                }
                
            }
        }
        
        return ans;
        
       
    }
    
    
    public void buildGraph(String [] dict, int N, int K){
       
        
        
        for(int i=0;i<N-1;i++){
            String S1=dict[i];
            String S2=dict[i+1];
            
                //compare S and word[j]
                for(int k=0;k<Math.min(S1.length(),S2.length());k++){
                    if(S1.charAt(k)!=S2.charAt(k)){
                        adj.putIfAbsent(S1.charAt(k),new ArrayList<Character>());
                        adj.get(S1.charAt(k)).add(S2.charAt(k));
                        indeg.putIfAbsent(S1.charAt(k),0);
                        indeg.putIfAbsent(S2.charAt(k),0);
                        break;
                    }
                }
            
        }
        for(char key:adj.keySet()){
            
            for(char to:adj.get(key)){
                indeg.put(to,indeg.getOrDefault(to,0)+1);
            }
        }
        
        
    }
}
