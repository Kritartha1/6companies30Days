class Solution {
    int doOverlap(int L1[], int R1[], int L2[], int R2[]) {
        // code here
        return ((L1[0]>R2[0])||(R1[0]<L2[0])||(R2[1]>L1[1])||(R1[1]>L2[1]))?0:1;
    }
}
//not overlapping case:
//(L1[0]>R2[0])--->means 2nd rectangle left of left edge of 1st rectangle
//(R1[0]<L2[0])--->means 2nd rectangle right of right edge of 1st rectangle
//(R2[1]>L1[1])--->means 2nd rectangle above to upper edge of 1st rectangle
//(R1[1]>L2[1])--->means 2nd rectangle below to lower edge of 1st rectangle
