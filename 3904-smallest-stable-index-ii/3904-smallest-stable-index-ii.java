class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] a = new int[n];
        int[] b = new int[n];
        a[0] = nums[0];
        for(int i = 1;i<n; i++)
        {
            if(nums[i]>a[i-1])
            {
                a[i] = nums[i];
            }
            else
            {
                a[i] = a[i-1];
            }
        }
        b[n-1] = nums[n-1];
        for(int i = n-2;i>=0; i--)
        {
            if(nums[i]<b[i+1])
            {
                b[i] = nums[i];
            }
            else
            {
                b[i] = b[i+1];
            }
        }
        for(int i =0 ; i<n; i++)
        {
            if(Math.abs(a[i] - b[i])<=k)
            {
                return i;
            }
        }
        return -1;
        

        
    }
}