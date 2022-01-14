class Solution
{
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N)
    {//Used  backtracking
    
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
            
            for(int i=0;i<k[a[L]].length();i++ ){
                
                String x=temp;// temp is stored at x to do backtracking
                
                temp+=k[a[L]].charAt(i);
                
                printString(L+1,R,ans,temp,a,k);
                
                temp=x;//backtracking step
                
                
                
                
            }
            
        }else{
            //means we presses all the digits..so we must have found a combination of string..
            
            ans.add(new String(temp));
            
            
            return ;
        }
    }
    
}
