class Solution
{
    //Function to count number of ways to reach the nth stair 
    //when order does not matter.
    Long countWays(int m)
    {
        // your code here
        long[] dp=new long[m+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=m;i++){
            dp[i]=1+dp[i-2];
            
            //at (i-2)th step, we can have two options..take a 2 step jump to ith step..
            //or take two 1 step jump to step i..
            //ek way toh jump(i-2) me hi aa jaayega..
            //dusra waala..ek extra 1 add karna padega for a 2 step jump..
            //we are not doing dp[i-1]+dp[i-2] bcoz ordering doesn't matter..
            //so reaching dp[i-2] will give one way to rech dp[i]..if we take 1 step at a time
            //then adding 1 to it gives the other way taking a 2 step to reach i th step
        }
        
        //we can also see ways(3)=ways(2)..i.e dp[3]=dp[2]..
        //dp[3]=dp[2]=x1
        //dp[5]=dp[4]=x1+1=x2
        //dp[7]=dp[6]=x1+1+1=x2+1=x3
        //if we initialize dp[0]=dp[1]=1..
        //we can have the relationship as dp[i]=dp[i-2]+1..
        //i.e dp[3]=dp[1]+1=dp[2]=dp[0]+1=x1
        return dp[m];
        
    }    
}
