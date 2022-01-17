class Solution
{
    int atoi(String str) {
	// Your code here
	int ans=0;
	int sign=1;
	int i=1;
	char ch=str.charAt(0);
	
	//this first character may denote the sign of the number
	if(ch=='-'){
	   sign=-1;
	}
	else if(ch=='+'){
	    sign=1;
	}
	else{
	    i=0;//then start iteration from first index and check every index
	}
	
	for(;i<str.length();i++){
	    if((str.charAt(i)<'0')||(str.charAt(i)>'9')){
	        return -1;
	    }
	    else{
	        
	        ans=(str.charAt(i)-'0')+ans*10;
	    }
	}
	return ans*(sign);
	
	
    }
}
