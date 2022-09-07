class Solution
{
  //practice.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1#
  
    //Function to find the largest number after k swaps.
    
    //Idea behind is to look for every swap(if valid) possible and look for the best answer...
    
    //Time complexity: O(nPk);
    
    public static void swap(int i,int j,char[] ch){
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }
    
    public static String max;
    static char[] ch;
    
    public static String findMaximumNum(String str, int k)
    {
            //code here.
        ch=str.toCharArray();
        max=str;
        findMaximum(str,k);
        return max;
            
            
    }
    
    public static void findMaximum(String str, int k){
    
        if(k==0){//if k swaps done then return from the function ....
        
            return ;
            
        }
            
        int n=str.length();
        
        //for eg: if str=1458
            
        for(int i=0;i<n;i++){
        
            for(int j=i+1;j<n;j++){
                    
                //'4'>'1'
                //swap 4 with 1
                //so now we will do perform the algorithm on str=4158...with k=k-1..bcoz we have done one swap..
                //likewise we have to check every valid swap positions possible
                    
                if(str.charAt(j)>str.charAt(i)){
                
                    swap(i,j,ch);
                        
                    String newString=new String(ch);
                    
                    if((max).compareTo(newString)<0){
                        max=newString;
                    }
                    
                    findMaximum(newString,k-1);
                        
                    swap(i,j,ch);
                    
                    }
                }
            }
            
        }
        
}

//Cleaner approach:

class Solution
{
    //O((n^k).
    //Function to find the largest number after k swaps.
    
    public static String findMaximumNum(String str, int k)
    {
            //code here.
        
        String ans=solve(str.toCharArray(),k,0);
        return ans;
    }
    static String solve(char[] s,int k,int i){
        if(i==s.length||k==0){
            return new String(s);
        }
        int j=i+1;
        String t=solve(s,k,i+1);
        for(;j<s.length;j++){
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            String v=solve(s,k-1,i+1);
            if(v.compareTo(t)>0){
                t=v;
            }
            
            temp=s[i];
            s[i]=s[j];
            s[j]=temp;
        }
        return t;
    }
}
