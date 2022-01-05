class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        int n=nums.length;
        if((n&1)!=0){//trivial condition
            return false;
        }
      //n1=k*q1+r1
      //n2=k*q2+r2
      //if (n1+n2)%k==0 means (r1+r2)%k must be 0
      //r1,r1 range:[0,k-1]
        int[] freqRemainder=new int[k];//will store each remainders
        
        for(int i=0;i<n;i++){
            freqRemainder[nums[i]%k]++;
        }
      
        int[] vis=new int[k];//visited array taken so that in the future iteration process once a pair is processed as true, we don't check for the same pair afterwards
        int r1=0;
        for(int i=0;i<n;i++){
            r1=nums[i]%k;
            if(vis[r1]==0){//means not visited
                //Case1:
              //r1==0..means (r1+r2)%k=(r2)%k must be 0..since r2<k..so..r2 must be 0 ..
              //so if count/freq of zero remainder is odd, then one of the zero reaminder can;t be paired..which will result as false
              
              //Case3: it's the special version of case 2..when k-r1=r1..
              //so freqRemainder[r1] and freqRemainder[k-r1] both will point to same address..
              //to make sure all of such k-r1 adn r1 make pairs, freqRemainder[r1]( which is equal to freqRemainder[k-r1]) must be even..else it will result as false
              if(r1==0||2*r1==k){
                    if((freqRemainder[r1]&1)!=0){
                       return false; 
                    }
                    
                
                }else{
                //Case2:
                //r1+r2 max value can be 2k-2..
                //so from (0,2k-2], no divisible by k is k itself..
                //so , if r1=x...r2 must be k-x..
                //so if to pair x and k-x , r1 and r2 count must be equal else false
                    if(freqRemainder[r1]!=freqRemainder[k-r1]){
                        return false;
                    }
                }
                vis[(k-r1)%k]=1;
                vis[r1]=1;
            }
        }
        return true;
    }
}
