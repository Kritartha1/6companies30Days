class Solution{
    static String decodedString(String s){
        // code here
        int n=s.length();
        Stack<Character> st=new Stack<>();//will take care of the characters to be added
        
        String ans="";
        for(int i=0;i<n;i++){
            if(s.charAt(i)==']'){//means we got one sequence
                String temp="";//to get the particular sequence
                //eg 3[2[ab]]
                //if i=6, char=']'
                //our sequence is ab
                while(st.peek()!='['){
                    temp=st.pop()+temp;
                }
                //got the sequence in temp
                //remaining stack 3[2[
                st.pop();
                //removing the leading '['
                String counter="";
                //getting the number given before each sequence
                while(!st.isEmpty()&&Character.isDigit(st.peek())){
                    counter=st.pop()+counter;
                }
                //in our eg: counter="2"
                int m=Integer.parseInt(counter);//now converting the counter string to it's integer equivalent
                StringBuilder repeat=new StringBuilder();
                //it will make the last found sequence to repeat m times..
                //and then we can append the final characters of string to the stack
                //our eg:m=2..
                //repeat=ab..1st iteration/
                //repeat=abab..2nd and last iteration..
                while(m--!=0){
                    repeat.append(temp);
                }
                
                temp=repeat.toString();//converting Stringbuilder to string
                
                //putting the characters of repeat(string) in our result stack
                
                for(int k=0;k<temp.length();k++){
                    st.push(temp.charAt(k));
                }
                //now stack=3[abab
            }
            else{
                //if we get numbers/alphabets/'[',we are adding it to the stack
                //eg: 3[2[ab
                st.push(s.charAt(i));
            }
        }
        while(!st.isEmpty()){
            //returning the characters of the stack by appending it as a final string
            ans=st.pop()+ans;
        }
        return ans;
        
    }
}
