package janchallange;

import java.util.Arrays;

public class SmallestStringGivenNumericValue {
    public String getSmallestString(int n, int k) {
        char[] chs = new char[n];
        Arrays.fill(chs, 'a');

        k -= n;

        for (int i = chs.length - 1; i >= 0; i--) {
            if (k <= 0) {
                break;
            }

            if (k >= 'z' - chs[i]) {
                k -= 'z' - chs[i];
                chs[i] = 'z';
            } else {
                chs[i] += k;
                k = 0;
            }
        }

        System.out.println(chs);
        return new String(chs);
    }

    public static void main(String[] args) {
        SmallestStringGivenNumericValue a = new SmallestStringGivenNumericValue();
        a.getSmallestString(5, 73);

    }
}
