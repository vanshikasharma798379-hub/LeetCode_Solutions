class Solution {
    public int[][] transpose(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] ans = new int[m][n];
        for(int i =0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                ans[i][j]=arr[j][i];     
            }
        }
        return ans;
        
    }
}
