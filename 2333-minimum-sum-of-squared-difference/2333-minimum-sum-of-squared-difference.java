class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long sum = 0;
        int max = 0;

        int n = nums1.length;
        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sum += diff[i];
            max = Math.max(max, diff[i]);
        }

        long k = (long) k1 + k2;

        if (sum <= k) {
            return 0;
        }

        int low = 0;
        int high = max;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long count = 0;

            for (int d : diff) {
                if (d > mid) {
                    count += d - mid;
                }
            }

            if (count <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long ans = 0;

        for (int d : diff) {
            int remaining = Math.min(d, low);
            ans += (long) remaining * remaining;
        }

        long used = 0;

        for (int d : diff) {
            if (d > low) {
                used += d - low;
            }
        }

        long extra = k - used;

        for (int d : diff) {
            int remaining = Math.min(d, low);

            if (extra > 0 && d >= low && low > 0) {
                ans -= (long) remaining * remaining;
                ans += (long) (remaining - 1) * (remaining - 1);
                extra--;
            }
        }

        return ans;
    }
}