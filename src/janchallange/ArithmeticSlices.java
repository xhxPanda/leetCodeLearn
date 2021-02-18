package janchallange;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;

        int[] dp = new int[A.length];
        int res = 0;
        int prevDiff = A[1] - A[0];
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == prevDiff) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }

            res += dp[i];
            prevDiff = A[i] - A[i - 1];
        }
        return res;
    }
}
