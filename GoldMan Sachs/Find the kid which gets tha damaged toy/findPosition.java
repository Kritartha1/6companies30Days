class Solution {
    static int findPosition(int N , int M , int K) {
        // code here
        int pos=K+(M-1);
        while(pos>N){
            pos-=N;
        }
        return pos;
    }
};
