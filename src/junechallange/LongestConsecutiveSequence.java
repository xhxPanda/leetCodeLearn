package junechallange;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> s = new HashSet<>();
        for (int i : nums) {
            s.add(i);
        }
        for (int i : nums) {
            if (s.remove(i)) {
                int pre = i - 1, next = i + 1;
                while (s.remove(pre)) {
                    pre--;
                }

                while (s.remove(next)) {
                    next++;
                }

                res = Math.max(res, next - pre - 1);
            }
        }
        return res;
    }
}
