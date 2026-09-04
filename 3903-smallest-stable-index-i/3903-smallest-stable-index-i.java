class Solution {
    public int firstStableIndex(int[] arr, int target) {
        int n = arr.length;
        for(int i =0; i<n; i++)
        {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int k = 0; k<=i; k++)
            {
                if(arr[k]>max)
                {
                    max = arr[k];
                }
            }
            for(int k = i; k<n; k++)
            {
                if(arr[k]<min)
                {
                    min = arr[k];
                }
            }
            if(Math.abs(max - min) <= target)
            {
                return i;
            }
        }
        return -1;
        
    }
}