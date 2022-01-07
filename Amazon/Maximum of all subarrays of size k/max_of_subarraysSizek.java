//User function template for JAVA

class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here
        int i=0;
        int j=0;
        Deque<Integer> q=new LinkedList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        //deque is taken so that head or the first element can be stored as max element..
        //and when new elements are added, it gets added to the tail..
        //so..when we add 1 3 2 4..
        //q=1
        //q=3
        //q=3 2.....(for the first three elements ..max is 3)
        //q=4..for the next three elements..i.e 3 2 4..max is 4
        //when new element(arr[j]) is added ...if the previous elements are smaller than arr[j]..
        //then the previous elements do not contribute to the max element of that k elements..
        //so its better to remove the smaller elements..
        //if new element is smaller than the previous elements..
        //then at a certain point of time..it may become max when previous elements are popped..
        //so when smaller elements are added ..add it to the tail
        while(j<n){
            while(q.size()>0&&q.getLast()<arr[j]){
                q.removeLast();
            }
            q.add(arr[j]);
            if(j-i+1==k){
                int first=q.peekFirst();
                ans.add(first);
                if(first==arr[i]){
                    q.removeFirst();
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}
