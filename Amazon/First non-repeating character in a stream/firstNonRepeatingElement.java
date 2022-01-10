class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        Queue<Character> nonRepNo=new LinkedList<>();
        char currChar=A.charAt(0);
        nonRepNo.add(currChar);
        int[] freq=new int[26];//26 letters of the alphabet frequencies
        
        StringBuilder ans=new StringBuilder();
        
        for(int i=0;i<A.length();i++){
            currChar=A.charAt(i);
            freq[currChar-'a']++;//incrementing the frequency of the currElement
            if(freq[currChar-'a']<2)//i.e if currElement freq==1,
            //then it can be a potential candidate of the first non rep element in future..
            //so adding it to the queue
            {
                nonRepNo.add(currChar);
            }
            
            //getting the first non rep element frojm the queue
            while(!nonRepNo.isEmpty()&&freq[nonRepNo.peek()-'a']>1){
                    
                    nonRepNo.poll();
            }
            //after the while loop ends we will have two cases:
            //case 1: all  elements are repeating
            //case 2: some elements are non repeating..
            //if it's case 1, after the while loop ends, the repeating elements will be freed from the queue
            //and then append a '#' character..
            //else case2: after while loop ends there wil be some element left in the queue..
            //the head of the queue gives the first non repeating element..
            //after the head, there may be some repeating elements..
            //but we need only the first non repeating element..
            //so the elemets after the head are of no use currently..
            
            if(nonRepNo.isEmpty()){
                    ans.append('#');
            }else{
                    ans.append(nonRepNo.peek());
            }
            
        
        
            
        }
        return ans.toString();
        
    }
}
