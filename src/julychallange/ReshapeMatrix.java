package julychallange;

public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c)
            return mat;

        int[][] mm = new int[r][c];
        int r1 = 0, c1 = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (c1 == c) {
                    r1++;
                    c1 = 0;
                }
                mm[r1][c1++] = mat[i][j];
            }
        }
        return mm;
    }
}
