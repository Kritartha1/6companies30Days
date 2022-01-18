class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
        String[] r=new String[2];
        HashMap<String,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }
        int maxScore=mp.get(arr[0]);
        String ans=arr[0];
        for(Map.Entry<String,Integer> entry:mp.entrySet()){
            int val=entry.getValue();
            String curr=entry.getKey();
            // System.out.println(curr+": "+val);
            
           if(val>maxScore){
               maxScore=val;
               ans=curr;
           }else if(val==maxScore && ans.compareTo(curr)>0 ){
               //when maxVotes are tied, we have to make the lexographically lesser name as winner
               
               //ans>curr, then compare to will return positve val..
               //if equal then 0 //
               //if less than then negative val
               ans=curr;
           }
            
            
        }
        r[0]=ans;
        r[1]=maxScore+"";
        return r;
        
    }
}

