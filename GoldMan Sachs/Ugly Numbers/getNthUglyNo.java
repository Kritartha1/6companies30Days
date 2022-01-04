class Solution {
    /* Function to get the nth ugly number*/
    long getNthUglyNo(int n) {
        // code here
      
     
      
      
      
      
        long[] ugly=new long[n];
        ugly[0]=1;
        int i2=0,i3=0,i5=0;
       //i2 is the indexing of twosNext ...i2=0,1,2...........
      //i3 is the indexing of twosNext ...i3=0,1,2...........
      //i5 is the indexing of twosNext ...i5=0,1,2...........
        long twosNext=2;
        long threesNext=3;
        long fivesNext=5;
      //twosNext={1*2,2*2,3*2,4*2,5*2,6*2,8*2,9*2,10*2,12*2...............}   multiples of 2 in the series of ugly nos in order.
      //threesNext={1*3,2*3,3*3,4*3,5*3,6*3,8*3,9*3,10*3,12*3.............}   multiples of 3 in the series of ugly nos in order.
      //fivesNext={1*5,2*5,3*5,4*5,5*5,6*5,8*5,9*5,10*5,12*5..............}   multiples of 5 in the series of ugly nos in order.
        long currUglyNo=1;
      //initialize ugly[0]=1...first ugly number
        for(int i=1;i<n;i++){
          //in each step of iteration we will compare min(twosNext[i2],threesNext[i3],fivesNext[i5])=ugly[i] and copy the value as next ugly number
      
    
            currUglyNo=Math.min(twosNext,Math.min(threesNext,fivesNext));
            ugly[i]=currUglyNo;
          //if ugly[i]==twosNext[i2], then increment i2 to get reference of its next address..so in the next iteration we will do min(twosNext[i2+1],threesNext[i3],fivesNext[i5])=ugly[i]
          //similary we will check for i3 and i5.....
          //since at some stage all three can have same value..so we have to make sure to have if statement for all the three ..i.e 2's,3's and 5's multiple
            if(currUglyNo==twosNext){
                ++i2;
                twosNext=ugly[i2]*2;
                
            }if(currUglyNo==threesNext){
                ++i3;
                threesNext=ugly[i3]*3;
                
            }if(currUglyNo==fivesNext){
                 ++i5;
                fivesNext=ugly[i5]*5;
            }
        }
        //then after final iteration we return the answer.
        return currUglyNo;
    }
}
