class Solution{
//practice.geeksforgeeks.org/problems/maximum-height-tree4803/1/?page=2&company%5b%5d=Walmart&query=page2company%5b%5dWalmart#
    static int height(int N){
        // code here
        int k=(-1+(int)Math.sqrt(1+(8*N)))/2;
        return k;
    }
}
