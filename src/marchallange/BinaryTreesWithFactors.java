package marchallange;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreesWithFactors {
    public int numFactoryBinaryTrees(int[] arr) {
        int n = arr.length;

        Arrays.sort(arr);

        long[] dp = new long[n];
        Arrays.fill(dp, 1);

        Map<Integer, Integer> map = new HashMap<>(0);
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        long result = 0;
        int lookBack = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    lookBack = arr[i] / arr[j];
                    if (map.containsKey(lookBack)) {
                        dp[i] += dp[j] * dp[map.get(lookBack)];
                    }
                }
            }
        }

        for (long v : dp) {
            result += v;
        }

        return (int) (result % 1_000_000_007);
    }
}
