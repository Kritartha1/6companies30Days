class Solution {
  
  //leetcode.com/problems/number-of-boomerangs/
  
    public int numberOfBoomerangs(int[][] points) {
        
        int n=points.length;
        int ans=0;
        
        HashMap<Integer,Integer> mp=new HashMap<>();
        
        
       for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               
               if(i==j){
                   
                   //this condn is not required..
                   //bcoz mp.get(dist(i,j))=mp.get(dist(i,i))=mp.get(0)=1..
                   //so v*(v-1)=1*0=0..this won't contribute to the answers
                   
                   continue;
               }
               
               int d=(int)distSq(points[i],points[j]);
               mp.put(d,mp.getOrDefault(d,0)+1);
               
               
           }
           
           //for i=I, we will get all the dist(I,j) for j ranging from 0 to n
           //
           for(int val:mp.values()){
               
               //val =number of pairs having a same dist..
               //so we have to take two such pairs..with i const..
               //so from val nos..we have to selct 2 such indexes..
               //for eg: (I,1) and (I,2) are two pairs..
               //so trio can be (I,1,2) or (I,2,1)..so for each combination we have two choices..
               //so..(NC2)*(2!)=N(N-1)
                ans+=(val)*(val-1);
               //this is (NC2)*(2!)=N(N-1)
            }
           
           mp.clear();
       }
        
        return ans;
        
    }
    
    public long distSq(int[] a,int[] b){
        
        long x=(a[0]-b[0])*(a[0]-b[0]);
        long y=(a[1]-b[1])*(a[1]-b[1]);
        
        return x+y;
        
    }
}
