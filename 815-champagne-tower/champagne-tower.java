class Solution {
    double dp[][] = new double[101][101];

    public double solve(int i, int j, int poured) {

        if (j < 0 || j > i)
            return 0.0;

        if (i == 0 && j == 0)
            return poured;

        if (dp[i][j] != -1)
            return dp[i][j];

        double left = Math.max(0.0, (solve(i - 1, j - 1, poured) - 1.0) / 2.0);
        double right = Math.max(0.0, (solve(i - 1, j, poured) - 1.0) / 2.0);

        return dp[i][j] = left + right;
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        for (int i = 0; i < 101; i++) {
            Arrays.fill(dp[i], -1);
        }
        return Math.min(1.0, solve(query_row, query_glass, poured));
    }
}