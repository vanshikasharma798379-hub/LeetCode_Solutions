class Solution {
    public int minOperations(String s) {
        int n = s.length();
        String d = s;
        int ans = Integer.MAX_VALUE;
        for (int r = 0; r < n; r++) {
            int cost = r;
            for (int i=0; i < n/2; i++) {
                char a = d.charAt((i+r)%n);
                char b = d.charAt((n-1-i+r)%n);

                int x = (b-a+26)%26;
                int y = (a-b+26)%26;

                cost += Math.min(x, y);
            }
            ans = Math.min(ans, cost);
        }
        return ans;
    }
}