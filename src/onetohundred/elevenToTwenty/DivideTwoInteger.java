package onetohundred.elevenToTwenty;

public class DivideTwoInteger {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return ~dividend;
        }

        long dividend1 = Math.abs((long) dividend);
        long divisor1 = Math.abs((long) divisor);

        int result = 0;
        while (dividend >= divisor1) {
            int shiftNum = 0;
            while (dividend1 >= divisor1 << shiftNum) {
                shiftNum++;
            }
            result += 1 << (shiftNum - 1);
            dividend1 -= divisor1 << (shiftNum - 1);
        }

        if (isNeg) {
            result = -result;
        }
        return result;
    }
}