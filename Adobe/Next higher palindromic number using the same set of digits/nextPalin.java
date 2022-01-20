/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//logic behind:
        //we traversed from mid to the left of the array and tried to find the first element which is decreasing i.e N[i]<N[i+1]..
        //let i at N[i]<N[i+1] is idx
        //now we are ready to swap the element and get the next smallest element which is just greater than the palindromic number..
        //now from i=i+1 to mid, we kept on checking the number which is just grater than N[i]....that is we are finding the element -
        //in the right half from i=i+1 i=mid..to get the number smallest number just greater than N[idx].. let say it smallest index
        //the elements from smallest found index to mid are all smaller than N[idx]..
        //swap smallest index element to element at idx ..
        //now from  i=idx+1 to i=mid are all decreasing in nature..
        //so we just reverse the string from i=idx+1 to i=mid..similarly we will do it for the right half..
        //at idx, we have the element just greater than the previous element present at i=idx..
        
        //for eg: N=2431342..
        //mid index =2(for calculating mid index don't take into account the single mid element when n is odd..)
        //N[1]>N[2]...N[0]<N[1]..so found the decreasing element ...at idx-0.
        //now from i=1 to i=2..the the smallest element just greater than N[0]=2 is N[2]=3..so swapped the elements..
        //now N=3421243..
        //from i=1 to i=2 elements are decreasing ...which as a number string has higher value..
        //so to get a lower value of string...we reversed the string from i=1 to i=2..and similarly done it at the right half..
        //now N=3241423..
        //so this is the smallest palindromic value just greater than the original string.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//to get a proper understanding ,do take a small palindromic string and visualize it in a notebook..at each step..

class Solution
{
    public void reverse(char[] chr,int l,int r){
        while(l<r){
            char temp=chr[l];
            chr[l++]=chr[r];
            chr[r--]=temp;
        }
    }
    public void swap(char[] chr,int i,int j){
        char temp=chr[i];
        chr[i]=chr[j];
        chr[j]=temp;
    }
    public String getAns(char[] chr,int n){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
                sb.append(chr[i]);
        }
            
         return sb.toString();
    }
    
    public String nextPalin(String N) 
    { 
        
        char[] str=N.toCharArray();
        
        int n=N.length();
        
        if(n>3){
            char temp;
            
            int mid=(n/2)-1;
            
            int i,j;
            
            for(i=mid-1;i>=0;i--){
                
                if(str[i]<str[i+1]){
                    
                    break;
                }
            }
            
            if(i<0){
                
                return "-1";
            }
            
            // sb.append(N.substring(0,i));
            int small=i+1;
            
            for(j=i+2;j<=mid;j++){
                
                if(str[j]>str[i]&&str[j]<=str[small]){
                    
                    small=j;
                    
                }
            }
            
            
            swap(str,i,small);
            swap(str,n-i-1,n-small-1);
            
            
            reverse(str,i+1,mid);
            
            if((n&1)!=0){//odd length
            
                reverse(str,mid+2,n-i-2);
                
            }else{
                
                reverse(str,mid+1,n-i-2);
                
            }
            
            
            String ans=getAns(str,n);
            return ans;
            
            
        }else{
            return "-1";
        }
    }
    
}
