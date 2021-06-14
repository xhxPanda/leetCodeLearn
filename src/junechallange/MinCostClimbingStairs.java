package junechallange;

import java.util.ArrayList;
import java.util.List;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        List<Integer> dp = new ArrayList<>(0);

        dp.add(cost[0]);
        dp.add(cost[1]);

        for (int i = 2; i < n; i++) {
            int k = cost[i] + Math.min(dp.get(i - 1), dp.get(i-2));
            dp.add(k);
        }
        return Math.min(dp.get(n - 1), dp.get(n - 2));
    }
}
