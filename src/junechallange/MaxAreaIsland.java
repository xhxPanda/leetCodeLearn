package junechallange;

public class MaxAreaIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, length(grid, i, j));
                }
            }
        }
        return max;
    }

    private int length(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;
        int num = 1;

        num += length(grid, row + 1, col);
        num += length(grid, row - 1, col);
        num += length(grid, row, col + 1);
        num += length(grid, row, col - 1);

        return num;
    }
}
