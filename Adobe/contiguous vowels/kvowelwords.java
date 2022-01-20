class Solution{
    public int kvowelwords(int N,int K){
        // code here
        double[][] dp=new double[N+1][K+1];
        double mod=(1e9);
        mod+=7;
        for(int i=0;i<=N;i++){
            for(int j=0;j<=K;j++){
                if(i==0){
                    dp[i][j]=1;//means no element 
                }else{
                    dp[i][j]=(dp[i-1][K]*21)%mod;
                    //means previous k elements are vowels..
                    //so the jth element will be consonant..
                    if(j>0){
                        dp[i][j]=(dp[i][j]+(dp[i-1][j-1]*5)%mod)%mod;
                        //so at jth element we have two options..
                        //ya toh jth element bhi vowel hoga..
                        //ya jth element consonants hoga
                        //dp[i-1][j-1]=previous j-1 elements are vowels..
                        //so dp[i][j]+=(dp[i-1][j-1])*5..
                        //multiplied by 5 to say that the jth element is vowel
                    }
                }
            }
        }
        return ((int)dp[N][K])%((int)mod);
        
    }
    
    
    
    
    
}
