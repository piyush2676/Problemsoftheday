
class Solution {
    Pair<Long, Long>[][] dp;
    int mod = 1000000007;
    int m, n;

    public Pair<Long, Long> f(int i, int j, int[][] grid) {
        if (i == m - 1 && j == n - 1) {
            return new Pair<>((long) grid[i][j], (long) grid[i][j]);
        }

        if (dp[i][j] != null) return dp[i][j];

        long maxval = Long.MIN_VALUE;
        long minval = Long.MAX_VALUE;

        if (i + 1 < m) {
            Pair<Long, Long> down = f(i + 1, j, grid);

            long a = grid[i][j] * down.getKey();
            long b = grid[i][j] * down.getValue();

            maxval = Math.max(maxval, Math.max(a, b));
            minval = Math.min(minval, Math.min(a, b));
        }

        if (j + 1 < n) {
            Pair<Long, Long> right = f(i, j + 1, grid);

            long a = grid[i][j] * right.getKey();
            long b = grid[i][j] * right.getValue();

            maxval = Math.max(maxval, Math.max(a, b));
            minval = Math.min(minval, Math.min(a, b));
        }

        dp[i][j] = new Pair<>(maxval, minval);
        return dp[i][j];
    }

    public int maxProductPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new Pair[m][n];

        Pair<Long, Long> result = f(0, 0, grid);

        long maxProduct = result.getKey();

        if (maxProduct < 0) return -1;

        return (int) (maxProduct % mod);
    }
}