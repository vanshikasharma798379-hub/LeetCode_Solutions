class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int lcount = 0;
        int max = 0;
        for(char i =0; i<n; i++)
        {
            if(s.charAt(i)=='(')
            {
                lcount++;
                max = Math.max(max , lcount);
            }
            if(s.charAt(i)==')')
            {
                lcount--;
            }
        }
        return max;

        
    }
}