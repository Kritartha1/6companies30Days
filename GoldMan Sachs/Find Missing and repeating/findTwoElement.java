// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        long s1=0;
        long s2=0;
        long t=1;
        for(int i=0;i<n;i++){
            s1+=arr[i]-t;//by doing like this we are saving it from Integer overflow
            s2+=(arr[i]-t)*(arr[i]+t);////by doing like this we are saving it from Integer overflow
            t++;
        }
        //x-r=s1
        //x^2-r^2=s2
        //so..x+r=s2/s1;
        //
        //let x+r=sum
        //x=(sum+s1)/2
        //r=sum-x;
        long sum=s2/s1;
       
        int[] ans=new int[2];
        ans[1]=0;//missing no
        ans[0]=(int)(sum+s1)/2;//repeating no
        ans[1]=(int)sum-ans[0];//missing no
        
        return ans;
    }
}
