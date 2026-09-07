class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        int n = s.length();
        int[] dp = new int[n + 1];
        int[] last = new int[26];
        for (int i = 0; i < 26; i++) {
            last[i] = -1;
        }
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int ch = s.charAt(i - 1) - 'a';
            dp[i] = (2 * dp[i - 1]) % mod;
            if (last[ch] != -1) {
                dp[i] = (dp[i] - dp[last[ch] - 1] + mod) % mod;
            }
            last[ch] = i;
        }
        return (dp[n] - 1 + mod) % mod;
    }
}