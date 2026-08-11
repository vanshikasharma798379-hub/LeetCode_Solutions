class Solution {
    public int pivotIndex(int[] arr) {
        int n = arr.length;
        int totalsum =0;
        for(int i =0; i<n; i++)
        {
            totalsum =totalsum+arr[i];
        }
        int leftsum=0;
        for(int i =0; i<n; i++)
        {
            int rightsum = totalsum-leftsum-arr[i];
            if(leftsum == rightsum)
            {
                return i;
            }
            leftsum = leftsum+arr[i];
        }
        return -1;

        
    }
}