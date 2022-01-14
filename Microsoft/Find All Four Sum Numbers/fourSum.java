// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Arrays.sort(arr);
        int n=arr.length;
        
        for(int i=0;i<n-3;i++){
            if(arr[i]>0&&arr[i]>k){//bcoz summing two negative numbers will be give smaller sum
            //-2+(-3)<-2
            //-2+(-3)<-3
            //so if arr[i]>0 and since array is sorted...
            //if arr[i]>0 and then next elements will be def positive and adding two positive numbers will always give greater sum
                break;
            }
            for(int j=i+1;j<n-2;j++){
                int l=j+1;
                int r=n-1;
                int s=arr[i]+arr[j];
                while(l<r){
                    if(s+arr[l]+arr[r]<k){
                        l++;
                    }else if(s+arr[l]+arr[r]>k){
                        r--;
                    }
                    else{
                        ArrayList<Integer> temp=new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[l]);
                        temp.add(arr[r]);
                        ans.add(temp);
                        
                        while(l<r&&arr[l]==temp.get(2)){//removing repeated numbers...since we need only unique combinations
                            ++l;
                        }
                        while(l<r&&arr[r]==temp.get(3)){//removing repeated numbers...since we need only unique combinations
                            --r;
                        }
                    }
                }
                while(j+1<n-2&&arr[j+1]==arr[j]){//removing repeated numbers...since we need only unique combinations
                    ++j;
                }
                
            }
            while(i+1<n-3&&arr[i+1]==arr[i]){//removing repeated numbers...since we need only unique combinations
                    ++i;
                }
            
        }
        
        return ans;
        
    }
}
