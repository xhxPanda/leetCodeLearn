package aprilchallange;

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        if (len == 0) {
            return 0;
        }

        int[][] dp = new int[m+1][n+1];
        for (String str : strs) {
            int num0 = getZero(str);
            int num1 = str.length() - num0;

            for (int i = m; i >= num0; i--) {
                for (int j = n; j >= num1; j--) {
                    dp[i][j] = Math.max(dp[i][j],dp[i-num0][j-num1]+1);
                }
            }
        }
        return dp[m][n];
    }

    private int getZero(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                res++;
            }
        }

        return res;
    }
}
