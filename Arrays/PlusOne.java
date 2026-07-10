class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] ans = new int[n];
        int carry = 1;
        for(int i =n-1; i>=0; i--)
        {
            if(digits[i]+carry<=9)
            {
                ans[i]=digits[i]+carry;
                carry=0;            
            }
            else
            {
                ans[i] = 0;
                carry = 1;
            }
        }
        if(carry==1)
        {
            int[] num =new int[n+1];
            num[0]=1;
        for(int i = 0; i<n; i++)
        {
           num[i+1]= ans[i];
        }
        return num;
        }
        return ans;
        
    }
}
