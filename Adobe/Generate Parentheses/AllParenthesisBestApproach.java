class Solution {
    
   
    
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        //assumed that there n will be minimum 1
        
        String temp="";//initializing the 1st character of each string
        
        List<String> ans=new ArrayList<>();
        
        int closingBrackets=0;//to keep a number of unclosed opening brackets..after each opening bracket is added ..this parameter increases..
        //and when a closed bracket is used this parameter decreases
        int openingBrackets=0;//to keep a count on the used opening brackets...after every open brackets used,this parameter increases
        
        solve(temp,n,openingBrackets,ans,closingBrackets);
        
        return ans;
        
    }
    
    //recursive tree:
    //initially we have temp="("..
    //so closingBrackets=1..i.e no. of unclosed brackets=1..
    //opening brackets=1..i.e no of used opening brackets=1..
    //at temp="(", it can add two things to it in the next step..
    //either case1: temp="()" or case2: temp="(("
    //solve recursively for case 1 and case 2..
    //for case 1 closingbrackets will decrease by 1..since the used opening brackets were all closed
    //for case 2 openingBrackets will increase by 1 and closing/unclosed brackets will increase by 1..
    //since when we add one '(' to the string one opening bracket is increased and so the no the number of unclosed brackets will also increase
    //
    //solve recursively for both case1 and case 2
    public void solve(String temp,int n,int openingBrackets,List<String> ans,int closingBrackets){
        
        //if all the opening brackets are used..
        //and all are closed i.e unclosed brackets=0..
        //so just return that string and add to the list
        if(openingBrackets==n&&closingBrackets==0){
            
            ans.add(new String(temp));
            return ;
        }
        

        if(closingBrackets!=0){
            //case 1
          
            solve(temp+')',n,openingBrackets,ans,closingBrackets-1);
            
        }
        //case2
        if(openingBrackets<n){
            solve(temp+'(',n,openingBrackets+1,ans,closingBrackets+1);
        }
        
        
         
    }
}
