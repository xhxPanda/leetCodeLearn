package febchallange;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend > divisor) {
            return 0;
        }

        int ans = 1;
        int sign = 1;

        if (dividend > 0) {
            sign = opposite(sign);
            dividend = opposite(dividend);
        }

        if (divisor > 0) {
            sign = opposite(sign);
            divisor = opposite(divisor);
        }

        int originDividend = dividend;
        int originDivisor = divisor;
        dividend -= divisor;
        while (divisor >= dividend) {
            ans = ans + ans;
            divisor += divisor;
            dividend -= divisor;
        }

        // 如果我我们传进去是两个负数
        int result = ans + opposite(divide(originDividend - divisor, originDivisor));
        if (result == Integer.MAX_VALUE) {
            if (sign > 0) {
                return Integer.MAX_VALUE;
            } else  {
                return Integer.MIN_VALUE;
            }
        } else {
            if (sign > 0) {
                return opposite(result);
            } else {
                return result;
            }
        }
    }

    private int opposite(int x) {
        return ~x + 1;
    }
}
