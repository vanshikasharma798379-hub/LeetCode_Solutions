class Solution {
    public int smallestNumber(int n, int t) {
        while(true)
        {
        int pro = 1;
        int n1 = n;
        while(n1>0)
        {
             int r = n1%10;
             pro = pro *r;
             n1 = n1/10;
        }
            if(pro%t==0) return n;
            n++;
        }
    }
}