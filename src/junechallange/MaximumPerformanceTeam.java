package junechallange;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumPerformanceTeam {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] se = new int[n][2];
        for (int i = 0; i < n; i++) {
            se[i] = new int[]{speed[i], efficiency[i]};
        }

        Arrays.sort(se, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);

        long max = 0, curSum = 0;
        for (int[] e : se) {
            pq.offer(e[0]);
            curSum += e[0];
            if (pq.size() > k) {
                curSum -= pq.poll();
            }
            max = Math.max(max, curSum * e[1]);
        }
        return (int) (max % (long)(1e9 + 7));
    }
}
