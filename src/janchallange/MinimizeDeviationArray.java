package janchallange;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimizeDeviationArray {
    public int minimumDeviation(int[] nums) {
        int result = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        Queue<Integer> queue = new PriorityQueue<>((a,b) -> b - a);

        for (int num : nums) {
            num = num % 2 == 1 ? num * 2 : num;
            queue.offer(num);
            min = Math.min(min, num);
        }

        while (true) {
            int max = queue.poll();
            result = Math.min(result, max - min);
            if (max % 2 == 1) {
                break;
            }
            max /= 2;
            min = Math.min(min, max);
            queue.offer(max);
        }
        return result;
    }
}
