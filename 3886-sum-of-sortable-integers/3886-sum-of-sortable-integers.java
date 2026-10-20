class Solution {
public int sortableIntegers(int[] nums) {
int n = nums.length;
int[] prefMax = new int[n + 1];
int[] suffMin = new int[n + 1];
int[] drop = new int[n];
    suffMin[n] = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++)
        prefMax[i + 1] = Math.max(prefMax[i], nums[i]);

    for (int i = n - 1; i >= 0; i--)
        suffMin[i] = Math.min(nums[i], suffMin[i + 1]);

    for (int i = 1; i < n; i++)
        drop[i] = drop[i - 1] + (nums[i - 1] > nums[i] ? 1 : 0);

    int ans = 0;

    for (int k = 1; k <= n; k++) {
        if (n % k != 0) continue;

        boolean ok = true;

        for (int s = 0; s < n; s += k) {
            int e = s + k - 1;
            int d = drop[e] - drop[s];

            if (nums[e] > nums[s]) d++;

            if (d > 1 || prefMax[s] > suffMin[s]) {
                ok = false;
                break;
            }
        }

        if (ok) ans += k;
    }

    return ans;
}

}
