class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][k + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int t = 0; t <= k; t++) {
                    dp[i][j][t] = Integer.MIN_VALUE;
                }
            }
        }

        int startUsed = (grid[0][0] > 0) ? 1 : 0;
        if (startUsed <= k) {
            dp[0][0][startUsed] = grid[0][0];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int used = 0; used <= k; used++) {

                    if (dp[i][j][used] == Integer.MIN_VALUE) continue;

                    if (j + 1 < n) {
                        int newUsed = used + (grid[i][j + 1] > 0 ? 1 : 0);
                        if (newUsed <= k) {
                            dp[i][j + 1][newUsed] = Math.max(
                                dp[i][j + 1][newUsed],
                                dp[i][j][used] + grid[i][j + 1]
                            );
                        }
                    }

                    if (i + 1 < m) {
                        int newUsed = used + (grid[i + 1][j] > 0 ? 1 : 0);
                        if (newUsed <= k) {
                            dp[i + 1][j][newUsed] = Math.max(
                                dp[i + 1][j][newUsed],
                                dp[i][j][used] + grid[i + 1][j]
                            );
                        }
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int used = 0; used <= k; used++) {
            ans = Math.max(ans, dp[m - 1][n - 1][used]);
        }

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}