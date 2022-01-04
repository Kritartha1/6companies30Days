class Solution {
    static int findPosition(int N , int M , int K) {
        // code here
        //n-k+1 is the number of positions left from i=K to i=N
        //if M<=n-k+1 then we can distribute the items in the first circle itself
        //first item can be distributed at k th posn..
        //2nd item at k+1 posn..3rd at k+2 posn..
        //so mth item at k+(m-1) posn..
        if(M<=(N-K+1)){
            return (M+K-1);
        }
        //if distribution needed revisiting the circle from 1st index,
        //then first distribute the items in the first circle..
        //the remaining items can be distributed with the help of remainder formula..
        //eg: if M=10,N=6,K=1..
        //then..M>(N-K+1)..
        //so first we distribute the elements in the remaning pos of 1st circle..
        //that is from k to N..
        //then M-(N-K+1) elements are left..
        //so now if we get the remainder of (M-(N-K+1)%N)..it gives the..
        //correct posn after distributing in the circle as many times possible..
        //if remainder ==0..means final distribution at N th index..
        //else final distribution at (M-(N-K+1))%N) index..bcoz its less than N
        
        M-=(N-K+1);
        return (M%N==0)?N:(M%N);
    }
};
