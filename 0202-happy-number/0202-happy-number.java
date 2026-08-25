class Solution {
    public boolean isHappy(int n) {
        while(n!=1 )
        {
            if(n==4)
            {
                return false;
            }
            int sum =0;
            while(n>0)
            {
                int r = n%10;
                sum+=r*r;
                n = n/10;
               
            }
            n = sum;
        }
        return true;
        
    }
}