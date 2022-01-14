class Solution{
    static int minSteps(int D){
        
        
        int i=1;
        int steps=1;
      
        //eg: if we have 10 nos..from 1 to 10..
        //max sum of 10 nos can be  1+2+...+10=55..
        //min sum=-55..
        //immediate smaller to max =55-(1*2)..i.e (-1)+2+3+...+10=53
        //immediate smaller to 53 is  =55-(2*2)..i.e 1-2+3+...+10=51..
        //so we have combined nos 1 to 10 manipulating the signs of each of them..
        //the min we can get is -55=-(n)(n+1)/2
        //max we can get is  55= (n)(n+1)/2..
        //and we get all the odd nos between -55,-53,-51.......51,53,55.
        //so if (n)(n+1)/2 is odd, then all combinations of n nos sum are odd..ike 55 53 51...-55
        // if (n)(n+1)/2 is even , then all combinations of n nos sum should be even..ike 36 34 32...-36...taking n as 8
      
        //so if we are having odd(even) D, then we have to reach the nearest (n)(n+1)/2 so that D<=(n)(n+1)/2, where n(n+1)/2 is also odd(even).
        //then all of the odd numbers between -(n)(n+1)/2 and (n)(n+1)/2 are possible...and since D<=(n)(n+1)/2..so we can get min nos so that we can get D
        
        
        
        while(true){
            int s=(i*(i+1))/2;
            if(s>=D&&((s-D)%2==0)){
                break;
            }
            ++steps;
            ++i;
        }
        return steps;
    }
}
