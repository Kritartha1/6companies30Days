class Solution {

//leetcode.com/problems/divide-two-integers/submissions/
//leetcode.com/problems/divide-two-integers/discuss/142849/C%2B%2BJavaPython-Should-Not-Use-%22long%22-Int
//leetcode.com/problems/divide-two-integers/discuss/13467/Very-detailed-step-by-step-explanation-(Java-solution)

    public int divide(int dividend, int divisor) {

        if(dividend==(-(1<<31))&&divisor==-1){
            return Integer.MAX_VALUE;//to lkeep an eye on the edge case..
            //in this qsn only one edge case is mentioned..
            //so edge keeping a check on that edge case
        }

        int ans=0;
        int a=Math.abs(dividend);
        int b=Math.abs(divisor);

        for(int q=31;q>=0;q--){
            if((a>>>q)-b>=0){
                System.out.println(a>>>q);
                System.out.println(q);
                ans+=(1<<q);
                a-=(b<<q);
            }
        }
        //eg: 10=(q)*3+r;
        //so 10=(2^i+2^j+....)*d+r;
        //where j<i
        //so 10=(2^1+2^0)*3+r;
        //10/2^1=(1+..)*3>=0
        //so we got one of our binary term for the quotient..
        //now adding 2^1 to the answer i.e 1^q.
        //deduct 2^1*3 ..e.10-2^1*3=(2^1+2^0)*3+r-2^1*3=(2^0)*3+r;
        //now check for lower val of p..and answer accordingly
    
        return (dividend>0)==(divisor>0)?ans: -ans;

}       
    
}
