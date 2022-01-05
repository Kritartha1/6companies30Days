////!!!!!Alert!!!
//this apprach will give TLE


class Solution{
    static String decodedString(String s){
        int m=s.length();
        
        StringBuilder ans= new StringBuilder();
        int n=0;
        int i=0;
        int a=0;
        int temp=0;
        while(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    temp+=(s.charAt(i++)-'0');
                    
                    n=temp;
                    temp*=10;
                   
        }
        i++;
        
        
        a=0;
        while(i<m-1){
            temp=0;
            
            
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                while(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    temp+=(s.charAt(i++)-'0');
                    
                    a=temp;
                    temp*=10;
                    
                }
                
            }else if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                ans.append(s.charAt(i++));
                
            }
            else if(s.charAt(i)=='['){
                i++;
                String temp2="";
                while(s.charAt(i)!=']'){
                        temp2+=s.charAt(i++);
                        
                }
                i++;
                for(int v=0;v<a;v++){
                        ans.append(temp2);
                       
                }
                a=0;
            }
        }
        StringBuilder str= new StringBuilder();
        
        for(i=0;i<n;i++){
            str.append(ans);
        }    
            
            
        return str.toString();
        
    }
}
