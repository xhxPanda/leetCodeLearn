package decemberchallange;

import java.util.*;

public class JumpGameFive {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>(0);
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer index = queue.poll();
                if(index == n - 1) {
                    return step;
                }

                for (int curIndex : map.get(arr[index])) {
                    if(curIndex != index && !visited[curIndex]) {
                        queue.offer(curIndex);
                        visited[curIndex] = true;
                    }
                }

                if (index - 1 >= 0 && !visited[index - 1]) {
                    queue.offer(index - 1);
                    visited[index - 1] = true;
                }

                if (index + 1 < n && !visited[index - 1]) {
                    queue.offer(index + 1);
                    visited[index + 1] = true;
                }
                map.get(arr[index]).clear();
            }
            step++;
        }
        return -1;
    }

}
