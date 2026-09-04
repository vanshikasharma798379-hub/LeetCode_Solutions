import java.util.Arrays;
class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int low = 1;
        int high = position[n-1]-position[0];
        int ans = 0;
        while(low<=high)
        {
            int mid = low +(high-low)/2;
            int count =1;
            int temp = position[0];
            for(int i =1; i<n; i++)
            {
                if(position[i]-temp>=mid)
                {
                    count++;
                    temp =position[i];
                }
            }
            if(count<m)
            {
                high = mid -1;
            }
            if(count>=m)
            {
                ans = mid;
                low = mid +1;
            }
        }
        return ans;
        
    }
}