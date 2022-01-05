import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RepeatMissing {



    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {


        ArrayList<Integer> ans=new ArrayList<>();
        BigInteger n=BigInteger.valueOf(A.size());

        BigInteger s=BigInteger.valueOf(0);
        BigInteger ss=BigInteger.valueOf(0);

        for(int x : A)
        {
            s=  s.add(BigInteger.valueOf(x));
            ss= ss.add(BigInteger.valueOf(x).multiply(BigInteger.valueOf(x)));
        }

        BigInteger as= n.multiply(n.add(BigInteger.valueOf(1))).divide(BigInteger.valueOf(2));
        BigInteger ass= as.multiply(BigInteger.valueOf(2).multiply(n).add(BigInteger.valueOf(1))).divide(BigInteger.valueOf(3));

        BigInteger sub=as.subtract(s);
        BigInteger add=(ass.subtract(ss)).divide(sub);
        //(ass-ss)/sub;

        int b = sub.add(add).divide(BigInteger.valueOf(2)).intValue();
        //(sub+add)/2;
        int a = BigInteger.valueOf(b).subtract(sub).intValue();

        ans.add(a);
        ans.add(b);
        return ans;




    }
}
