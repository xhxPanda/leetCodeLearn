package marchallange;

import java.util.Arrays;

/**
 * dp解法
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if (n == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int lookBack = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    lookBack = dp[i - coins[j]];
                    if (lookBack != Integer.MAX_VALUE) {
                        dp[i] = Math.min(1 + lookBack, dp[i]);
                    }
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] arrayA = new int[]{1, 2, 5};
        coinChange.coinChange(arrayA, 11);
    }
}
