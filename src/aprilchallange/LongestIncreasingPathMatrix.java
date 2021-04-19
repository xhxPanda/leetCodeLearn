package aprilchallange;

import java.util.Arrays;

public class LongestIncreasingPathMatrix {
    public int ans;
    public int[][] dirs = new int[][]{
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    public int longestIncreasingPath(int[][] matrix) {
        ans = 0;
        int[][] max = new int[matrix.length][];
        for (int i = 0; i < max.length; i++) {
            max[i] = new int[matrix[0].length];
            Arrays.fill(max[i], -1);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans = Math.max(ans, dfs(matrix, max, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int[][] max, int oldX, int oldY) {
        if (max[oldX][oldY] != -1) return max[oldX][oldY];
        int len = 1;
        for (int k = 0; k < dirs.length; k++) {
            int x = oldX + dirs[k][0];
            int y = oldY + dirs[k][1];
            if (!go(matrix, x, y)) continue;
            if (matrix[x][y] <= matrix[oldX][oldY]) continue;
            len = Math.max(len, dfs(matrix, max, x, y) + 1);
            max[oldX][oldY] = len;
        }
        return len;
    }

    public boolean go(int[][] matrix, int x, int y) {
        return x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length;
    }
}
