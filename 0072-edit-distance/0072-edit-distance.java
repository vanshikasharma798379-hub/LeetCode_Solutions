class Solution {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return edit(word1, word2, m, n, dp);
    }

    public static int edit(String word1, String word2,
                           int m, int n, int[][] dp) {

        if (m == 0) {
            return n;
        }

        if (n == 0) {
            return m;
        }

        // Already calculated
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (word1.charAt(m - 1) == word2.charAt(n - 1)) {

            dp[m][n] = edit(word1, word2, m - 1, n - 1, dp);

        } else {

            int insert = edit(word1, word2, m, n - 1, dp);
            int delete = edit(word1, word2, m - 1, n, dp);
            int replace = edit(word1, word2, m - 1, n - 1, dp);

            dp[m][n] = 1 + Math.min(
                insert,
                Math.min(delete, replace)
            );
        }

        return dp[m][n];
    }
}