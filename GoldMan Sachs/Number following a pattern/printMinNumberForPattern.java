class Solution{
    static String printMinNumberForPattern(String S){
        // code here
      //
      //
        Stack<Integer> st=new Stack<>();
        StringBuilder ans=new StringBuilder();
        int t=1;
        int n=S.length();
        for(int i=0;i<n;i++){
            char c=S.charAt(i);
            if(c=='D'){
                st.push(t++);
            }else{
                st.push(t++);
                while(st.size()!=0){
                    ans.append(st.pop());
                }
            }
        }
        //bcoz we need (n+1) length characters..
        //and the above loop runs for n times..which will give n characters
        //eg:DDI
        //the above loop will give 321
        //but ans should be 3214...4 for the I increment step..
        //so the above loop doesn't account for the last char pattern..
        //the following steps will account for the the last pattern character
        st.push(t);
        while(st.size()!=0){
            ans.append(st.pop());
        }
        return ans.toString();
    }
}
