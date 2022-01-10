class Solution
{
    String colName (long n)
    {
        // your code here
        //like hexadecimal..can have digits 0 to F
        //26-binary ..will have char A to Z..
        //so solve it like a binary qsn
        StringBuilder ans=new StringBuilder();
        while(n!=0){
            char c='A';
            char r=(char)(c+(n-1)%26);
            ans.append(r);
            n=(n-1)/26;
            
        }
        ans.reverse();
        return ans.toString();
    }
}
