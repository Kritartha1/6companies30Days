class GfG
 {
	String encode(String str)
	{
          //Your code here'
          String ans="";
          int i=0;
          int n=str.length();
          while(i<n){
              int temp=1;
              char c=str.charAt(i++);
              while(i<n){
                  if(str.charAt(i)!=c){
                      break;
                  }
                  i++;
                  temp++;
              }
              ans+=c+String.valueOf(temp);
          }
          return ans;
	}
	
 }
