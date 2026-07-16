class Solution {
    public int maximumCount(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int pos= 0;
        int neg = 0;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(arr[mid]>=0)
            {
                high = mid-1;
            }
            else
            {
                low=mid+1;
                neg=low;
            }

        }
        low = 0;
        high = n-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(arr[mid]<=0)
            {
                low = mid+1;
            }
            else
            {
                high=mid-1;
            }

        }
         pos = n-low;
        int max = Math.max(neg,pos);
        return max;

        
    }
}
