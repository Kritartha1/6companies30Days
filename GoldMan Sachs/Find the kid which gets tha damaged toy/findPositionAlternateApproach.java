class Solution {
 public:
   int findPosition(int n , int m , int k) {
       // code here
       if(n==1){
           return 1;
       }
     int x= (m%n + k-1);
       return x==n ? x : x%n;
   }
};
