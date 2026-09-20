class Solution {
    public int scoreOfString(String s) {
        int n  = s.length();
        int ans = 0;
        for(int i = 0; i<n-1 ; i++)
        {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i+1);
            int value1 = ch1;
            int value2 = ch2;
            int temp = Math.abs(value1 -value2);
            ans = ans + temp ;
        }
        return ans;
        
        
    }
}