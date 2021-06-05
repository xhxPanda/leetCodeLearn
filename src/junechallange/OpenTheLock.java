package junechallange;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedBlockingDeque<>();
        HashSet<String> set = new HashSet<>(Arrays.asList(deadends));

        queue.add("0000");

        int step = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (set.contains(cur)) {
                    continue;
                }

                if (cur.compareTo(target) == 0) {
                    return step;
                }

                set.add(cur);
                for (int j = 0; j < 4; i++) {
                    for (int k = -1; k < 2; k += 2) {
                        char[] temp = cur.toCharArray();
                        temp[j] = (char)((temp[j] - '0' + k + 10) % 10 + '0');
                        queue.add(new String(temp));
                    }
                }
            }
        }
        return -1;
    }
}
