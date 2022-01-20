class Solution
{
    static long[][] dp;
    static int X;
    static long mod=(long)(1e9)+7l;
    
    static int numOfWays(int n, int x)
    {
        // code here
        X=x;
        int sq=(int)Math.round(Math.pow(n,1.0/x));
        
        dp=new long[n+1][sq+1];
        for(long[] row:dp){
            Arrays.fill(row,-1);
        }
        
        //dp[n][sq] will store the ans of no of ways to get n using numbers from 1 to (n)^(1/x)..
        //checked till xth root of n, because ..
        //let's take an eg: n=100...(n)^(1/2)=10..
        //so 100 can be written as sum of squares of numbers less than or equal to 10..
        //if we take let's say 11^2 which is 121..which exceeds 100..
        //10^2=100 ..so we got one of our ans...
        //1^2 + 3^2 + 4^2 + 5^2 + 7^2=100 which is another way..
        //6^2 + 8^2=100 which is the other way..
        
        ways(n,sq);
        
        return (int)dp[n][sq];
        
        
    }
    static long ways(int n,int i){
        // if(n==6 &&i==1){
        //     System.out.println("oye");
        // }
        if(n==0){
            return 1;
        }
        if(i<=0||n<0){
            return 0;
        }
        
        
        
        if(dp[n][i]!=-1){
            
            return dp[n][i];
        }
        
        int m=n-(int)Math.pow(i,X);
        //recursion tree is like:
        //if n=100..
        //we are starting from i=10..
        //so at i=10 we have two options either to take 10 or discard 10 and move to the next number i.e 9..and look for the sum..
        //if we take i=10..it will contribute to the sum as 10^2..
        //so n-10^2=100-10^2=0...remaining sum=0...so after taking 10 we got a way...
        //if we discard i=10..we move to i=9 and check for the remaing sum..
        //remaining sum=100-0=100..bcoz we haven't taken i=10..
        //and we recursively calculate for both the decisions taken and not taken..
        
        dp[n][i]=(ways(m,i-1)%mod+ways(n,i-1)%mod)%mod;
        
         
        // System.out.println("i="+i+"---->(n-i^2)="+(n-(i*i))+"-----> n="+n);
        // System.out.println("Hell "+(ways(i-1,n-(i*i))%mod));
        // System.out.println("Hello!! "+(ways(i-1,n)%mod));
        
        return dp[n][i];
    }
}
