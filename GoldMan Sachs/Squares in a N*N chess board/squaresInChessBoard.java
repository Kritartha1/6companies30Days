class Solution {
    static Long squaresInChessBoard(Long N) {
        // code here
        double ans=((2*N)+1)*N*(N+1);
        //total squares=1^2+2^2+3^2+4^2+...N^2
        //N^2=total 1*1 squares.
        //(N-1)^2=total 2*2 squares...and so on..
        //sum of the above series =(N)(N+1)(2N+1)/6
        
        ans/=6;
        long a=(long)ans;
        return a;
    }
};
