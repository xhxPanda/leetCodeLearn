package junechallange;

import java.util.Arrays;

public class MaximumAreaPieceCakeAfterHorizontalVerticalCuts {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int hl = horizontalCuts.length;
        int vl = verticalCuts.length;

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int maxH = Math.max(horizontalCuts[0], h - horizontalCuts[hl-1]);
        int maxV = Math.max(horizontalCuts[0], h - horizontalCuts[hl-1]);

        for (int i = 0; i < hl - 1; i++) {
            maxH = Math.max(maxH, horizontalCuts[i + 1] - horizontalCuts[i]);
        }
        for (int i = 0; i < vl - 1; i++) {
            maxV = Math.max(maxH, verticalCuts[i + 1] - verticalCuts[i]);
        }

        return (int)((long)maxH * maxV % 1000000007);
    }
}
