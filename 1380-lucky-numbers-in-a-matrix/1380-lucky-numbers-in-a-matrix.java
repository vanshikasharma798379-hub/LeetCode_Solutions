class Solution {
    public List<Integer> luckyNumbers(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;
        for(int i =0; i<n; i++)
        {
            int min = Integer.MAX_VALUE;
            int col = 0;
            for(int j=0; j<m; j++)
            {
                if(mat[i][j]<min)
                {
                    min = mat[i][j];
                    col = j;
                }
            }   
                int max = Integer.MIN_VALUE;
                for(int k = 0; k<n; k++)
                {
                    if(mat[k][col]>max)
                    {
                        max = mat[k][col];
                    }
                }
                if(min == max)
                {
                    ans.add(min);
                }
        }
        return ans;
        
    }
}