package maychallange;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleThree {

    public int scheduleCounrse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;

        for (int[] cours : courses) {
            time += cours[0];
            maxHeap.offer(cours[0]);
            if (time > cours[1]) {
                time -= maxHeap.poll();
            }
        }
        return maxHeap.size();
    }
}
