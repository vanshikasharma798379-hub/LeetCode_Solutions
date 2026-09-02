class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;
        int max = Integer.MAX_VALUE;
        for(int  i = 0; i<n; i++)
        {
            if(piles[i]>max)
            {
                max =piles[i];
            }
        }
        int high = max;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            long sum =0;
            for(int i =0; i<n; i++)
            {
                if(piles[i]%mid==0)
                {
                     sum += piles[i]/mid;
                }
                else
                {
                    sum += piles[i]/mid +1;
                }

            }
            if(sum>h)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return low;
        
    }
}