class Solution {
    long mod = 1000000007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int[][] up = new int[n + 1][m];
        int[][] down = new int[n + 1][m];

        for (int i = 0; i < up.length; i++) {
            Arrays.fill(up[i], 0);
            Arrays.fill(down[i], 0);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) continue;

                if (i < j) {
                    up[2][j] = (int) ((up[2][j] + 1) % mod);
                } else {
                    down[2][j] = (int) ((down[2][j] + 1) % mod);
                }
            }
        }

        for (int i = 3; i <= n; i++) {
            int[] prefixup = new int[m + 1];
            int[] prefixdown = new int[m + 1];

            for (int j = 0; j < m; j++) {
                prefixup[j + 1] = (int) ((prefixup[j] + up[i - 1][j]) % mod);
                prefixdown[j + 1] = (int) ((prefixdown[j] + down[i - 1][j]) % mod);
            }

            for (int y = 0; y < m; y++) {
                up[i][y] = prefixdown[y];
                down[i][y] = (int) ((((long) prefixup[m] - prefixup[y + 1]) % mod + mod) % mod);
            }
        }

        long ans = 0;

        if (n == 1) {
            ans = m;
        } else {
            for (int i = 0; i < m; i++) {
                ans = (ans + up[n][i] + down[n][i]) % mod;
            }
        }

        return (int) ans;
    }
}