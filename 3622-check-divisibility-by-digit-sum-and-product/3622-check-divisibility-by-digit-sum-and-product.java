class Solution {
    public boolean checkDivisibility(int n) {
        int sum =0 ;
        int pro = 1;
        int num = n;
        while(n!=0)
        {
            int r = n %10;
            sum+=r;
            pro*=r;
            n = n/10;
        }
        if(num % (sum+pro)==0)
        {
            return true;
        }
        return false;
        
    }
}