package aprilchallange;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // 优先队列中存储最大的ladders个高度差，这些差值将使用梯子
        PriorityQueue<Integer> q = new PriorityQueue<>();
        // 需要使用砖块的 高度 的和
        int sumHeight = 0;

        // 循环每一个高度
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff > 0) {
                q.offer(diff);
                if (q.size() > ladders) {
                    int minHeight = q.poll();
                    sumHeight += minHeight;
                }
                if (sumHeight > bricks) {
                    return i;
                }
            }
        }
        return heights.length - 1;
    }
}
