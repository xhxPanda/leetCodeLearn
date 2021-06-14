package junechallange;

import java.util.Comparator;
import java.util.PriorityQueue;

public class JumpGameVI {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparing(e->-e[0]));
        for (int i = 0; i < n; i++) {
            while (q.size() > 0 && q.peek()[1] + k < i) {
                q.poll();
            }

            dp[i] = nums[i] + (q.size() > 0 ? q.peek()[0] : 0);
            q.add(new int[]{dp[i], i});
        }
        return dp[n - 1];
    }

}
