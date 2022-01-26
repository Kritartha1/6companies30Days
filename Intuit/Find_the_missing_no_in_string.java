/*Complete the function below*/
class GfG
{
    //**Explanation://www.geeksforgeeks.org/find-missing-number-string-numbers-no-separator/
    //qsn link://practice.geeksforgeeks.org/problems/find-the-missing-no-in-string/1/#
    private int Val(String s,int i,int m){
        
        if(i+m>s.length()){
            //if m length digit can't be existed in the string then return -1
            return -1;
            
        }
        
        int val=0;//we get the current number in the string of m digits...
        
        for(int j=0;j<m;j++){
            
            int digit=s.charAt(j+i)-'0';
            
            if(digit<0||digit>9){
                return -1;
            }
            
            val=(val*10)+digit;

        }
        
        return val;
    }
    
    
	public int missingNumber(String s)
       {
       //add code here.
      int  n=s.length(); 
      
      for(int m=1;m<=6;m++){
           
          int N=Val(s,0,m);
          
           if(N==-1){
               break;
           }
           
           int missingNo=-1;
           
           boolean test=false;
           //to keep check if we got our answer..
           //if after an iteration test is false..means we must have got our missing no..
           //so return the missing no..
           //else..if test =true..prepare for the next iteration..
           
           //m is length of a digit..
           //if m=2 ...strig starts with a 2 digit number..
           //though in due time with increment 2 digit may become 3 digit..
           //eg : starts with 99..so next pattern must be 100 or 101..which is 3 digits..
           //Note: 101 written bcoz//in case 100 can be the missing no..
           
           for(int i=m;i<n;i+=1+Math.log10(N)){
               
               //Math.log10(N)+1 returns the digit of the number N
               
               //case1: missing no is N+1..
               if(missingNo==-1&&Val(s,i,(int)(1+Math.log10(N+2)))==N+2)
               {
                   missingNo=N+1;
                   
                   N+=2;
               }
               //case 2:next number is not missing
               else if(Val(s,i,(int)(1+Math.log10(N+1)))==N+1){
                   N++;
               }
               //case 3: invalid pattern...
               else{
                   
                   test=true;
                   break;
               }
           }
           
           //if we got our answer in our iteration return it..
           if(!test){
               return missingNo;
           }
       }
       return -1;
       
       }
}
