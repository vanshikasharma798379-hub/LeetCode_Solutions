class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int sum = 0;
        for(int i =0 ; i<n; i++)
        {
            char ch = s.charAt(i);
            int temp = 'z'- ch + 1;
            int pro = temp*(i+1);
            sum = sum + pro;

        }
        return sum;
    }
}