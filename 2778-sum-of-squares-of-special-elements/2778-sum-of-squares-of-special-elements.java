class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum =0;
        for(int i =1; i<=n; i++)
        {
            if(n%i == 0)
            {
                int p = nums[i-1]*nums[i-1];
                sum =sum + p;
            }
        }
        return sum;
        
    }
}