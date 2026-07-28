import java.util.Arrays;
class Solution {
    public int kthSmallest(int[][] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n*n];
        int index= 0;
        for(int i =0 ; i<n;i++)
        {
            for(int j =0; j<n; j++)
            {
                ans[index]=arr[i][j];
                index++;
            }
        }
        Arrays.sort(ans);
        return ans[k-1];

        
    }
}
