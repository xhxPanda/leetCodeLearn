package marchallange;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelipes) {
        int n = envelipes.length;
        if (n == 0) {
            return 0;
        }

        Arrays.sort(envelipes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] = o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        int max=0;
        boolean[] started = new boolean[envelipes.length];
        for (int i = 0; i < n; i++) {
            if (!started[i]) {
                max = Math.max(max, getMaxEnvelopes(envelipes, i, started));
            }
        }
        return max;
    }

    private int getMaxEnvelopes(int[][] envelopes, int startIndex, boolean[] started) {
        int max = 1;
        int width = envelopes[startIndex][0];
        int height = envelopes[startIndex][1];
        for (int i = startIndex + 1; i < envelopes.length; i++) {
            if (envelopes[i][0] > width && envelopes[i][1] > height) {
                started[i] = true;
                int num = getMaxEnvelopes(envelopes, i, started) + 1;
                max = max > num ? max : num;
            }
        }
        return max;
    }
}
