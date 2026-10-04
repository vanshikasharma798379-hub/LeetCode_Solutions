class Solution {
    public int minRotations(String s) {
        int n = s.length();
        int current = 0;
        int total = 0;
        for(int i = 0; i<n; i++)
        {
            int tar = s.charAt(i)-'0';
            int dis = Math.abs(tar-current);
            total = total+ Math.min(dis , 10-dis);
            current = tar;
        }
        return total;
        
    }
}