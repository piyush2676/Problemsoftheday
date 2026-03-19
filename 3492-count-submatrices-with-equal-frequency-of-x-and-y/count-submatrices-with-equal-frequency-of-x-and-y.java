class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] cumsumx = new int[m][n];
        int[][] cumsumy = new int[m][n];

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                cumsumx[i][j] = (grid[i][j] == 'X') ? 1 : 0;
                cumsumy[i][j] = (grid[i][j] == 'Y') ? 1 : 0;
                if (i > 0)
                    cumsumx[i][j] += cumsumx[i - 1][j];
                if (j > 0)
                    cumsumx[i][j] += cumsumx[i][j - 1];
                if (i > 0 && j > 0)
                    cumsumx[i][j] -= cumsumx[i - 1][j - 1];
                if (i > 0)
                    cumsumy[i][j] += cumsumy[i - 1][j];
                if (j > 0)
                    cumsumy[i][j] += cumsumy[i][j - 1];
                if (i > 0 && j > 0)
                    cumsumy[i][j] -= cumsumy[i - 1][j - 1];
                if (cumsumx[i][j] == cumsumy[i][j] && cumsumx[i][j] > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}