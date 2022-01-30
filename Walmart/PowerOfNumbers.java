//User function Template for Java
//practice.geeksforgeeks.org/problems/power-of-numbers-1587115620/1/?company%5b%5d=Walmart&company%5b%5d=Walmart&page=1&query=company%5b%5dWalmartpage1company%5b%5dWalmart#

class Solution
{
    long mod=(long)(1e9)+7;
    
    //Binary exponentiation...
    
    //www.youtube.com/watch?v=K8mJ27S72v0&t=537s
    
    long power(int N,int R)
    {
        //Your code here
        long ans=1;
        while(R>0){
            if((R&1)!=0){
                ans=(ans*N)%mod;
            }
            N=(int)(((N%mod)*(N%mod))%mod);
            R=R>>1;
        }
        return (ans);
        
    }

}
