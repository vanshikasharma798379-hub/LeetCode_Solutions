class Solution {
    public int maxLength(int[] nums) {
        int mx = 0, ml = 1;
        for (int x : nums) {
            mx = Math.max(mx, x);
            ml = lcm(ml, x);
        }
        int maxP = ml * mx;
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int product = 1;
            int g = 0;
            int l = 1;
            for (int j = i; j < n; j++) {

                product *= nums[j];

                g = gcd(g, nums[j]);

                l = lcm(l, nums[j]);

                if (product == g * l) {
                    ans = Math.max(ans, j - i + 1);
                }

                if (product > maxP) {
                    break;
                }
            }
        }
        return ans;
    }
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}