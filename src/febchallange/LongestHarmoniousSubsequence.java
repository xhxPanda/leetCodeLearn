package febchallange;

import java.util.HashMap;
import java.util.Set;

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> numCount = new HashMap<Integer, Integer>();
        for (int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }

        int maxLen = 0;
        Set<Integer> keys = numCount.keySet();
        for (int key : keys) {
            if (numCount.containsKey(key + 1)) {
                maxLen = Math.max(maxLen, numCount.get(key + 1) + numCount.get(key));
            }
        }

        return maxLen;
    }
}