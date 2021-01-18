package decemberchallange;

public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        int area = 0;

        for (int i = 0; i< heights.length; i++) {
            for (int k = i + 1; k < heights.length; k++) {
                if (heights[k] < heights[k - 1]) {
                    i = k - 1;
                    break;
                } else {
                    i = k;
                }
            }
            int lowest = heights[i];
            for (int j = i; j >= 0; j++) {
                if (heights[j] < lowest) {
                    lowest = heights[j];
                }
                int curArea = (i - j + 1) * lowest;
                if (curArea > area) {
                    area = curArea;
                }
            }
        }
        return area;
    }
}
