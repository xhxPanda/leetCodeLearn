package junechallange;

public class StoneGameVII {
    public int stoneGameVII(int[] stones) {
        int len = stones.length;
        int[][] dp = new int[len][len];
        int[] sum = new int[len + 1];

        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + stones[i];
        }

        for (int i = len - 2; i >= 0; i--) {
            for(int j=i+1; j<len; j++){
                dp[i][j] = Math.max(sum[j + 1] - sum[i + 1], sum[j] - sum[i] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1];
    }
}
