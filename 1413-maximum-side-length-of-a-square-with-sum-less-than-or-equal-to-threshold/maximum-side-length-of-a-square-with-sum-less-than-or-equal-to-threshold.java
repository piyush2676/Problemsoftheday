class Solution {

    private int sumsquare(int i, int j, int r2, int c2, int[][] prefix) {
        int sum = prefix[r2][c2];

        if (i > 0)
            sum -= prefix[i - 1][c2];

        if (j > 0)
            sum -= prefix[r2][j - 1];

        if (i > 0 && j > 0)
            sum += prefix[i - 1][j - 1];

        return sum;
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] prefix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i][j] =
                        (i > 0 ? prefix[i - 1][j] : 0) +
                        (j > 0 ? prefix[i][j - 1] : 0) -
                        (i > 0 && j > 0 ? prefix[i - 1][j - 1] : 0) +
                        mat[i][j];
            }
        }

        int bestside = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int offset = bestside; 
                     i + offset < m && j + offset < n; 
                     offset++) {

                    int r2 = i + offset;
                    int c2 = j + offset;

                    int sum = sumsquare(i, j, r2, c2, prefix);

                    if (sum <= threshold) {
                        bestside = Math.max(bestside, offset + 1);
                    } else {
                        break;
                    }
                }
            }
        }

        return bestside;
    }
}
