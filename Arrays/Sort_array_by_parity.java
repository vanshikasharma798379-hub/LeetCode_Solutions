class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        for(int i = 0; i<n; i++)
        {
            int pos = 0;
            for(int j= i; j<n; j++)
            {
                if(nums[j]%2==0)
                {
                    pos = j;
                    break;
                }
            }
            if(pos!=0)
            {
            int temp = nums[i];
            nums[i] = nums[pos];
            nums[pos] = temp;
            }
        }
        return nums;
        
    }
}
