class Solution
{
    //Function to count number of ways to reach the nth stair 
    //when order does not matter.
    Long countWays(int m)
    {
        // your code here
        return (long)(m/2)+1;
        //if m==8..
        //ways can be: 
        //1 1 1 1 1 1 1 1 --->length=m=8
        //2 1 1 1 1 1 1 --->length=m-1=7
        //2 2 1 1 1 1 --->length=m-2=6
        //2 2 2 1 1 --->length=m-3=5
        //2 2 2 2 --->length=m-4=4=m/2
        //loop runs (int)(m/2)+1 times=5
        //here total ways =5=(m/2)+1
        
        //if m==9
        //1 1 1 1 1 1 1 1 1--->length=m=9
        //2 1 1 1 1 1 1 1--->length=m-1=8
        //2 2 1 1 1 1 1--->length=m-2=7
        //2 2 2 1 1 1--->length=m-3=6
        //2 2 2 2 1--->length=m-4=5
        //loop runs (int)(n/2)+1 times=5
        //here total ways =5=(m/2)+1
        
    }    
}
