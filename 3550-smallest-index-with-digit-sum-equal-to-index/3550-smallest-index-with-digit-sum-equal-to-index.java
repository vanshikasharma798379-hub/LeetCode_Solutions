class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for(int i = 0; i<n; i++)
        {
            int sum = 0;
            int temp = nums[i];
            while(temp>0)
            {
                int j = temp%10;
                sum = sum + j;
                temp = temp/10;
            }
            if(sum == i)
            {
                return i;
            }
            
        }
        return -1;
        
    }
}