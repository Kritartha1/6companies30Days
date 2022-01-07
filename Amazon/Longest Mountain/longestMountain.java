class Solution {
    public int longestMountain(int[] arr) {
        int n=arr.length;
        int i=0;
        int max=0;
      //[A0,A1,A2,A3,A4,A5,A6,A7]..
      //then max increasing element A[i+1]>A[i] can be till i=5..i.e A6>A5 can be max edge case..since from pivot point the elements should decrease also..
      //i.e if A6>A5..then i++..i.e i becomes i=6..so i=6 is pivot point
      //then to make a mountain of A[i+1] <A[i] should be valid after i=6..i.e A7<A6..
      //so pivot point i can have max value i=n-2..
        while(i<n-2){
            if(arr[i]<arr[i+1]){//bcoz this is how a mountain starts
                int t=i;//storing starting window point....to get the width at the end of the mountain
                
                while(i<n-2&&arr[i]<arr[i+1]){//[A0,A1,A2,A3,A4,A5,A6...checking till A6..i.e i+1=6..i.e i+1=n-2..i.e i=n-3
                    i++;
                }
              //now when loop breaks, arr[i]==arr[i+1] can be a case..or arr[i]<arr[i+1] can be a case..when the elements are increasing and not decreasing..
              //in both cases we can't get a window
              
             
                
                if(arr[i]>arr[i+1]){ //if after pivot point elements decrease..then we are getting a mountain
                    
                    while(i<n-1&&arr[i]>arr[i+1]){
                        
                    i++;
                    }
                    
                    max=Math.max(max,i-t+1);//(i-t+1) is current windows width
                }
             }
            else{//else search for another index..bcoz (arr[i]>arr[i+1]) and (arr[i]==arr[i+1]) can't start a mountain
                i++;
            }
            
        }
        return max;
    }
}
