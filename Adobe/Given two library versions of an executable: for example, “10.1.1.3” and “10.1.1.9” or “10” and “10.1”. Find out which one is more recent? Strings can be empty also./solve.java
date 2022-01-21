

import java.util.*;
import java.lang.*;
import java.io.*;


class Adobe
{
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0){

            String x=sc.next();
            String y=sc.next();
            if(x.length()==0&&y.length()==0){
                System.out.println("No strings provided");
            }
            if(x.length()==0){
                System.out.println("Latest version: "+x);
            }
            if(y.length()==0){
                System.out.println("Latest version: "+y);
            }

            System.out.println("Latest version: "+new Sol().solve(x,y));





        }

       
	}
}
class Sol{

    public static String solve(String x,String y){

        String[] a=x.split("\\.");
        String[] b=y.split("\\.");
        int i=0;
        int n=Math.min(a.length, b.length);
        while(i<n){
            int r=a[i].compareTo(b[i]);

            if(r==0){
                ++i;

            }else if(r>0){
                return x;
            }else{
                return y;
            }
        }

        return x;


    }
}


