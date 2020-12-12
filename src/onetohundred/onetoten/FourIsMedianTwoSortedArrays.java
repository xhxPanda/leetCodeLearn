package onetohundred.onetoten;

public class FourIsMedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] numb1, int[] numb2) {
        int total = numb1.length + numb2.length;
        boolean isEven = (total&1) == 0;
        int target = isEven ? total/2 : (total-1)/2;

        double sum = 0;
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i <= target; i++) {
            boolean changed = false;
            if(index1 == numb1.length){
                index2++;
            } else if(index2 == numb2.length) {
                index1++;
                changed = true;
            } else if(numb1[index1] < numb2[index2]) {
                index1++;
                changed = true;
            } else {
                index2++;
            }

            if(i == target) {
                sum+=changed?numb1[index1-1]:numb2[index2 - 1];
            } else if(isEven && (i==target-1)) {
                sum += changed ? numb1[index1-1] : numb2[index2-1];
            }
        }

        return isEven ? sum/2 : sum;
    }
}
