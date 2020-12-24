package decemberchallange;

public class CherryPickUpTwo {
    private int pickUp(int[][] gird) {
        if (gird == null || gird.length == 0 || gird[0].length == 0) {
            return 0;
        }
        int n = gird.length;
        int m = gird[0].length;
        int[][][] dp = new int[n][m][m];
        return dfs(gird, dp, n, m, 0, 0, m - 1);
    }

    private int dfs(int[][] gird, int[][][] dp, int n, int m, int row, int col1, int col2) {
        if(row == n) {
            return 0;
        }

        if(dp[row][col1][col2] != 0) {
            return dp[row][col1][col2];
        }

        int value = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j<= 1; i++) {
                int nCol1 = col1 + i;
                int nCol2 = col2 + j;
                if(nCol1 >= 0 && nCol1 < m && nCol2 >= 0 && nCol2 < m) {
                    value = Math.max(value, dfs(gird, dp, n, m, row + 1, nCol1, nCol2));
                }
            }
        }
        // 最后一步，从9个状态里面最大的那个来到当前的格子，[row][col1][col2]
        value += gird[row][col1];
        if (col1 != col2) {
            value += gird[row][col2];
        }
        dp[row][col1][col2] = value;
        return dp[row][col1][col2];
    }
}
