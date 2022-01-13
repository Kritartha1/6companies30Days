
class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    
    {
        //O(n)...worst case O(2n)
        int[] ans=new int[n];
        Stack<Integer> S=new Stack<>();
        S.push(0);
        ans[0]=1;
        //Stack will store the nearest gretest element to left
      
       for(int i=1;i<n;i++){
           //top of the stack will always store the nearest gretest element  pos to the left
         
           while(!S.isEmpty()&&price[S.peek()]<=price[i]){//will pop all the consecutive smaller elements to theleft and stop when reached an element greter than the curr element
               S.pop();
           }
           ans[i]=(S.empty())?(i+1):(i-S.peek());
           //(S.empty means all elements to the left are smaller than the curr element)
           //if S is not empty then we found the nearest position from i to the left where prices[k]>prices[i]..
           //so from day k+1 to day i ..all elements are smaller..
           //eg: day0 day1 day2 day3 day4..
           //if prices[day2]>prices[day4]and prices[day3]<=prices[day4]..
           //then span for day4 is 2...day3 and day4.. which is equal to 4-2..
           
           S.push(i);//it will act as ngl for the next i+1 the element
           
       }
       return ans;
    }
    
    
}
