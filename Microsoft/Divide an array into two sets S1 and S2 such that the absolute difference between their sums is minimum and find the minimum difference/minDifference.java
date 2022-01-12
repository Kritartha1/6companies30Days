class Solution
{

	public int minDifference(int arr[], int n) 
	
	//Variation of knapsack..
	//to find min subset sum diff..
	//i.e if S=arr[0]+...arr[n-1]..
	//S1+S2=S..
	//S1=S-S2
	//we need min|S1-S2|
	//i,e min |S-2*S2|
	//so we will fillup the dp table for subset sum for all sum from S=0 to S=S
	//Further explanation in my dp 1 notebook..from subset sum problem..
	
	{ 
	    // Your code goes here
	    int sum=0;
	    for(int a: arr){
	        sum+=a;
	    }
	    boolean[][] dp=new boolean[n+1][sum+1];
	    
	    for(int i=0;i<=n;i++){
	        for(int j=0;j<=sum;j++){
	            if(i==0){
	                dp[i][j]=false;
	                
	            }if(j==0){
	                dp[i][j]=true;
	                
	            }
	        }
	    }
	    
	    
	    for(int i=1;i<=n;i++){
	        for(int j=1;j<=sum;j++){
	            if(arr[i-1]<=j){
	                
	                dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
	            }else{
	                dp[i][j]=dp[i-1][j];
	            }
	        }
	    }
	    //the last row of the dp table will have sum ranging from 0 to S taking all the n elements..
	    //and S1,S2 clearly<=S..
	    //so we will check |S-2*j|.....(where j =0,1,2....sum) in the last row where dp[n][j]=true
	    //the j close to S/2 will fetch the min |S-2j|
	    //we will check j from 0 to S/2..
	    //since we are taking mod i.e |S-2j|..
	    //so when the left half of S/2 and right half of S/2 will fetch same result..
	    //Why? kyuki S1 liya ya S2 liya baat toh same hi hai..
	    //if S=5..
	    //and S1=2 S2=3..and S1=3 S2=2..dono same hi toh baat hai..
	    //so..S1 ko S/2 k range me hi dekhenge..
	    

	    int ans=sum;
        
        for(int i=sum/2;i>=0;i--){
            if(dp[n][i]){
                ans=sum-2*i;
                break;
            }
        }
	    
	    return ans;
	} 
}
