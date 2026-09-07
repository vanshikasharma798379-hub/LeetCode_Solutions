class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0)
        {
            return 0 ;
        }
        int[] dp = new int[n];
        for(int i =0; i<n; i++)
        {
            dp[i] = -1;
        }
        return solve(nums , 0, dp);

        
    }
    public int solve(int[] nums , int i , int[]dp)
    {
        int n = nums.length;
        if(i>= n )
        {
            return 0;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        int rob = nums[i]+solve(nums , i+2 , dp);
        int nrob = solve(nums, i+1 , dp);
        dp[i]= Math.max(rob , nrob);
        return dp[i];
    }
}