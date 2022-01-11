//User function Template for Java

/*
delete n nodes after m nodes
The input list will have at least one element  
Node is defined as
  class Node
  {
      int data;
      Node next;
      Node(int data)
      {
          this.data = data;
          this.next = null;
      }
  }
*/

class Solution
{
    static void linkdelete(Node head, int M, int N)
    {
        // your code here
        Node curr=head;
        
        while(curr!=null){
            for(int i=1;i<M&&curr!=null;i++){//this loop will run M-1 times..
            //so that we can get the previous node just before deleting begins 
                curr=curr.next;
            }
            //at this step curr=the Mth node 
            if(curr==null){
                return;
            }
            Node Next=curr;
            //Next reference to delete N nodes
            //N+1 times to get the first node after deleting N nodes
            for(int i=0;i<=N&&Next!=null;i++){//this loop will run N+1 times
                Next=Next.next;
            }
            curr.next=Next;
            
            curr=Next;//
            
        }
        
    }
}


