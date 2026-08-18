class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return count(nums , 0 , 0 ,target);
        
    }
    public int count(int[] nums , int idx , int sum , int target)
    {
        if(idx == nums.length)
        {
            if(sum == target)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        int p = count(nums,idx+1,sum+nums[idx], target);
        int m = count(nums,idx+1,sum-nums[idx], target);
        return p+m;

    }
}