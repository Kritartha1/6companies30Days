class Solution

{
    //Hard hai bhai!!
    
    static class element{
        int val;
        int idx;
        int row;
        
        element(int val,int idx,int row){
            this.val=val;
            this.idx=idx;
            this.row=row;
        }
    }
    
    static int INT_MAX=Integer.MAX_VALUE;
    
    static int INT_MIN=Integer.MIN_VALUE;
    
    static PriorityQueue<element> pq;//min heap to get the min element
    
	static int[] findSmallestRange(int[][] KSortedArray,int n,int k)
	{
	    //add your code here
	    int[] ans=new int[2];
	    
	    pq=new PriorityQueue<>(new Comparator<element>(){
	        
        public int compare(element o1,element o2){
            
            return o1.val-o2.val;
        }
        
        });
        
	    int minRange=INT_MAX;//to keep a check on the min range of the k lists
	    int maxVal=INT_MIN;//will store the min value of the range
	    int minVal=INT_MAX;//will store tha max value of the range
	    
	    for(int i=0;i<k;i++){
	        //inseting the first elements of each lists..
	        pq.add(new element(KSortedArray[i][0],0,i));
	        maxVal=Math.max(KSortedArray[i][0],maxVal);
	        
	    }
	    //keep a pointer for each lists..each starting at index=0 for the individual lists ..
	    //when min value is retrieved by any list..we compare the range..
	    //then increase the index of that list..to get a value greater than min value..
	    //so that range becomes smaller..
	    
	    //logic: as the lists are sorted ..so when checking element from each list and iterating further ..
	    //the elements will always increase with iteration..
	    //so we will always be getting greater range with every iteration..
	    //range=max-min..
	    //to get minimum range, min must increase...
	    //so after we get a min value..we compare it with the range nad update the range..
	    //then increase the pointer of the list where min val is present ..remove the min element..ehich we have already done using pq.poll()
	    //then repeat the steps..in a loop..
	    
	    while(!pq.isEmpty()){
	        //loop will run for altmost N*K times..
	        //with inserting takes log(k) operations..
	        //so time complexity O(n * k *log k)
	        
	        element min=pq.poll();//will retrieve the min value..and remove it
	        
	        int curr_MIN_VAL=min.val;
	        int idx=min.idx;
	        int row=min.row;
	        
	        if(minRange>maxVal-curr_MIN_VAL){
	            minRange=maxVal-curr_MIN_VAL;
	            minVal=curr_MIN_VAL;
	            ans[0]=minVal;
	            ans[1]=maxVal;
	        }
	        
	        ++idx;
	        
	        if(idx==n){
	            //if any of the list exhausts, then we got our range ..
	            break;
	        }
	        //inserting takes log(k) times..
	        pq.add(new element(KSortedArray[row][idx],idx,row));
	        
	        maxVal=Math.max(maxVal,KSortedArray[row][idx]);//checking if the newly added element can be max val of the range
	        
	        
	        
	    }
	    
	    
	    return ans;
	    
	    
	}
}
