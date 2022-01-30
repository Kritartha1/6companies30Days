class Solution {
  //leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
  //Easy question.
    public boolean winnerOfGame(String colors) {
        int a=0;
        int b=0;
        
        int i=1;
        int n=colors.length();
        
        while(i<n-1){
            
            char c=colors.charAt(i);
            
            if(colors.charAt(i+1)==c&&colors.charAt(i-1)==c){
                if(c=='A'){
                    a++;
                }else{
                   b++;
                }   
            }
            
            ++i;
        }
        
//         System.out.println("Alice:"+a+" .Bob:"+b);
        
        return a>b;
        
    }
}
