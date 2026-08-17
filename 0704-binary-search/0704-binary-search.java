class Solution {
    public int search(int[] nums, int target) {
    int n = nums.length;
        int first = 0;
        int last = n-1;
        while(first<=last)
        {
            int mid = (first+last)/2;
            if(nums[mid]>target)
            {
                last = mid-1;
            }
            if(nums[mid]<target)
            {
                first = mid+1;
            }
            if(nums[mid]==target)
            {
                return mid;
            }
        }
        return -1;
        
    }
}