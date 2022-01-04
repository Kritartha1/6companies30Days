class Solution
{
    public int CountWays(String str)
    {
        // code here
       int n=str.length();
       if(str.charAt(0)=='0'){
           return 0;
       }
       int[] dp=new int[n+1];
       dp[0]=1;//empty string ..1 way
       dp[1]=1;//single character..1 way..
        for(int i=2;i<=n;i++){
            int singleLastDigit=0;
            //means the current ith digit if it is non zero single digit..
            //so, to keep check on this singleLastDigit variable is taken
            int doubleLastDigit=0;
            //means the last two digit (i-2)th char + (i-1)th char string..substring(i-2,i)
            //if it is valid 2 digit whose value is less than 26.
            //so, to keep check on this DoubleLastDigit variable is taken
            if(str.charAt(i-1)>'0'){
                //if current char =='0',then it will be an invalid single char..
                //so char==0 will return 0..
                //else it will return dp[i-1]..bcoz..
                //1234..if curr digit is 3,then it is considered a valid single digit..
                //so ways to decode 123 will be same as ways to decode 12..
                singleLastDigit=dp[i-1];
            }
            if(str.charAt(i-2)=='1'||str.charAt(i-2)=='2'&&str.charAt(i-1)<'7'){
                //it checks the previous digit and the current digit..
                //if both digits as a substring int value < 27 then it is a valid two digit no
                //so 1234..---->>23 is a valid double digit..so its ways will be same as calculating "1"'s ways'..
                //i.e dp[i-2]..
                //if its invalid then doibleLastDigit =0
                doubleLastDigit=dp[i-2];
            }
            dp[i]=(doubleLastDigit+singleLastDigit)%1000000007;
            
        }
        return dp[n];
        
    }
    
}
