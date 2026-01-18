class Solution {
    public int largestMagicSquare(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] rowprefixsum = new int[m][n];
        for (int i = 0; i < m; i++) {
            rowprefixsum[i][0] = grid[i][0];
            for (int j = 1; j < n; j++) {
                rowprefixsum[i][j] = rowprefixsum[i][j - 1] + grid[i][j];
            }
        }

        int[][] colprefixsum = new int[m][n];
        for (int j = 0; j < n; j++) {
            colprefixsum[0][j] = grid[0][j];
            for (int i = 1; i < m; i++) {
                colprefixsum[i][j] = colprefixsum[i - 1][j] + grid[i][j];
            }
        }

        for (int side = Math.min(m, n); side >= 2; side--) {
            for (int i = 0; i + side - 1 < m; i++) {
                for (int j = 0; j + side - 1 < n; j++) {

                    int targetsum =
                            rowprefixsum[i][j + side - 1] -
                            (j > 0 ? rowprefixsum[i][j - 1] : 0);

                    boolean allsame = true;
                    for (int r = i + 1; r < i + side; r++) {
                        int rowsum =
                                rowprefixsum[r][j + side - 1] -
                                (j > 0 ? rowprefixsum[r][j - 1] : 0);

                        if (rowsum != targetsum) {
                            allsame = false;
                            break;
                        }
                    }
                    if (!allsame) continue;
                    for (int c = j; c < j + side; c++) {
                        int colsum =
                                colprefixsum[i + side - 1][c] -
                                (i > 0 ? colprefixsum[i - 1][c] : 0);

                        if (colsum != targetsum) {
                            allsame = false;
                            break;
                        }
                    }
                    if (!allsame) continue;
                    int diag = 0;
                    int antidiag = 0;

                    for (int k = 0; k < side; k++) {
                        diag += grid[i + k][j + k];
                        antidiag += grid[i + k][j + side - 1 - k];
                    }

                    if (diag == targetsum && antidiag == targetsum) {
                        return side;
                    }
                }
            }
        }

        return 1;
    }
}
