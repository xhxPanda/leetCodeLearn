package febchallange;

public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix.length - 1, y = 0;
        while (true) {
            if (matrix[x][y] > target) {
                x--;
            } else if (matrix[x][y] < target){
                ++y;
            } else {
                return true;
            }
            if (x < 0 || y >= matrix[0].length) {
                break;
            }
        }
        return false;
    }
}
