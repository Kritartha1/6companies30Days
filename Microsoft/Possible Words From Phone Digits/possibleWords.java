class Solution
{
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N)
    {//Used bit manipulation and backtracking
    
        // your code here
        ArrayList <String> ans=new ArrayList<>();
        String[] k=new String[10];
        char x='a';
        for(int i=2;i<7;i++){
            k[i]=""+x;
            x++;
            k[i]+=x;
            x++;
            k[i]+=x;
            x++;
            
        }
        k[7]="pqrs";
        k[8]="tuv";
        k[9]="wxyz";
        
        String temp="";
        printString(0,N-1,ans,temp,a,k);
        return ans;
        
        
    }
    static void printString(int L,int R,ArrayList <String> ans,String temp,int a[],String[] k){
        if(L<=R){
            
            int f=2;//f will denote the index of the the string eg number 2="abc"..
            
            int j=(a[L]==7||a[L]==9)?8:4;
            //j denotes the current binary representation of the number pressed 
            
            ////if digit pressed is other numbers except 7 or 9,
            //let's say digit 2="abc" pressed
            //so it can provide any of the 3 characters(among a ,b and c)
            //lets denote  abc as binary..
            //if we need a,then binary representation is 100..=4(decimal)
            //if we need b, then binary representation is 010..=2
            //if we need c,then binary representation is 001..=1
            //**so binary representation of character representation for the digit starts at 100, the gradually decreases by power of 2..
            
            
            if(j==8){
                f=3;
            }
            //if digit pressed is 7 or 9,
            //let's say digit 7="pqrs" pressed
            //so it can provide any of the 4 characters(among p ,q ,r and s)
            //lets denote  pqrs as binary..
            //if we need p,then binary representation is 1000..=8(decimal)
            //if we need q, then binary representation is 0100..=4
            //if we need r,then binary representation is 0010..=2
            //if we need s, then binary representation is 0001..=1
            //***so binary representation of character representation for the digit starts at 1000, the gradually decreases by power of 2..
            
            for(;j>=1;j=j>>1 ){
                //let's say a is pressed
                //so j=4 at first iteration..j=4 represents a
                //so j will be 2,1,0 after next iterations
                //j=2 represents b//
                //j=1 represents c
                
                
                int t=f-(int)(Math.log(j)/Math.log(2));
                //(Math.log(j)/Math.log(2))=log(j)base 2..
                //if j==4, then 2nd bit is set.. (indexed 0)
                //i.e 100="abc"
                //so log(j)base 2 =2..
                //if we need a from abc, which is located at 0th string index..
                //which is equal to 2-log(j)base index posn..=2-2=0
                
                //if j==2, then 1st bit is set.. (indexed 0)
                //i.e 010="abc"
                //so log(j)base 2 =1..
                //if we need b from abc, which is located at 1th string index..
                //which is equal to 2-log(j)base index posn..=2-1=1..
                
                
                String x=temp;// temp is stored at x to do backtracking
                
                temp+=k[a[i]].charAt(t);
                
                printString(i+1,R,ans,temp,a,k);
                //lets say a[]={2,3,4}
                //at this step lets say we got our final string "adg"
                //for the next iteration ..we should get adh..then adi
                //so that means we have to remove the last character added fpr the next iteration to proceed
                
                temp=x;//backtracking step
                
                
                
                
            }
            
        }else{
            //means we presses all the digits..so we must have found a combination of string..
            
            ans.add(new String(temp));
            
            
            return ;
        }
    }
    
}


