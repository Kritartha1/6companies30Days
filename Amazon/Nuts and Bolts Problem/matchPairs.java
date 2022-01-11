class Solution {
  
  //Doing quick sort..
  //comparing nuts element with a pivot element from bolts ..
  //comparing bolts element with a pivot element from nuts. ..
  
  ////////////////////////////////////////////////////////
  //Imp: no duplicate elements are present in the arrays//
  ////////////////////////////////////////////////////////
    
    void matchPairs(char nuts[], char bolts[], int n) {
        // code here
        matchPairs(nuts,bolts,0,n-1);
        
    }
    
    void matchPairs(char nuts[], char bolts[],int l,int r){
        if(l<r){
            int pivot=partition(nuts,l,r,bolts[r]);
            //the previous code make a partition of the nuts array wrt to the last element of the bolts array
            //elements before partition are lesser and elements after partition are greater than bolts[r]
            
            partition(bolts,l,r,nuts[pivot]);
            //it make a partition of the boltss array wrt to the same bolts[r] element 
            //but, as no two same array elements are to be compared..
            //so we take nuts[pivot]..which will obviously be equal to bolts[r] from the previous step
            //elements before partition are lesser and elements after partition are greater than nuts[pivot]
            
            
            
            matchPairs(nuts,bolts,l,pivot-1);
            //recursing for the elements before the pivot
            matchPairs(nuts,bolts,pivot+1,r);
            //recursing for the elements after the pivot
        }
    }
    
    int partition(char arr[],int l,int r,int pivot){
        int i=l;
        char temp1;
        for(int j=l;j<r;j++){
            //smaller elements are pushed to the left part of the array
            if(arr[j]<pivot){
                temp1=arr[i];
                arr[i++]=arr[j];
                arr[j]=temp1;
            }
            //if the pivot element eg bolts[r] is found,then we are pushing it to the last index
            //so that we can retrieve it at the last step and place it at the pivot position
            else if(arr[j]==pivot){
                temp1=arr[j];
                arr[j--]=arr[r];
                arr[r]=temp1;
            }
        }
        
        //grabbing the pivot element and placing it on the pivot point
        temp1=arr[i];
        arr[i]=arr[r];
        arr[r]=temp1;
        
        //returning the pivot position
        return i;
        
        
    }
}
