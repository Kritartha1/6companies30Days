class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int n1=str1.length();
        int n2=str2.length();
        if(n1>n2){
            int temp=n1;
            n1=n2;
            n2=temp;
        }
      //if both strings have a common divisor, then both strings added opposite oder should fetch same results..
      //for eg: str1="ABCABCABC"...str2="ABC"
      //str1+str2=ABCABCABCABC
      //str2+str1=ABCABCABCABC
      //if str1 = "LEET", str2 = "CODE"
      //str1+str2=LEETCODE
      //str2+str1=CODELEET
      //so str1!=str2..so..for a common divisor,,,str1+str2==str2+str1 should be satisfied..
        if((str1+str2).equals(str2+str1)){
            return str1.substring(0,gcd(n1,n2));
        }else{
            return "";
        }
      
        
        
        
           
        
    }
    //https://youtu.be/JUzYl1TYMcU
    //https://cp-algorithms.com/algebra/euclid-algorithm.html
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}
