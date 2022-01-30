class Solution
{
    //Function to find total number of unique paths.
    //Bottom up approach ''space effiicient and time efficient
    //practice.geeksforgeeks.org/problems/number-of-unique-paths5339/1/#
   
    public static int NumberOfPath(int a, int b) 
    {
        //simple combination problem..
        //total steps to reach bottom most row from top most row=a-1;
        //total steps to reach right most col from left most col=b-1;
        //so total steps needed =a-1+b-1=a+b-2..
        //to reach the last box..we need a combination of (a-1) down move and (b-1) right move..
        
        //so total ways=(a+b-2)C(a-1)=(a+b-2)C(b-1)= (a+b-2)!/(a-1)!(b-1)!
        
        int ans=1;
        //(n+m-2)             (n+m-2)!      (n+m-2)(n+m-3)....n       n  (n+1)          (n+m-2)
        //     C         = -------------- = ---------------------  = ---*-----*........*--------
        //      (m-1)       (n-1)!(m-1)!     (m-1)(m-2).....1         1    2             (m-1)
        
        for(int i=b;i<a+b-1;i++){
            ans*=i;
            ans/=(i-b+1);
        }
        return ans;
        
        
    }
    
   
}
