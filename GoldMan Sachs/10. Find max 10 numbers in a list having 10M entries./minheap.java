
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long[] ans=new long[10];
        long t = sc.nextLong();
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        while(t--!=0){
            minHeap.add(sc.nextInt());
            if(minHeap.size()>10){
                minHeap.poll();
            }
        }
        Iterator<Integer> itr=minHeap.iterator();
        int i=0;
        while(itr.hasNext()){
            ans[i]= itr.next();
            System.out.println(ans[i++]);
        }



    }
}
