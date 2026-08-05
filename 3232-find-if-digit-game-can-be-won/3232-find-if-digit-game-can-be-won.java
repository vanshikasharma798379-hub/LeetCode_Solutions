class Solution {
    public boolean canAliceWin(int[] arr ) {
        int n = arr.length;
        int total =0;
        int sum1 =0;
        int sum2 = 0 ;
        for(int i =0; i<n; i++)
        {
          total = total +arr[i];  
        }
        for(int i =0; i<n; i++)
        {
            int num = arr[i];
            if(num>=0 && num<=9)
            {
                sum1 = sum1 +num;
            }
            if(num>=10 && num<=99)
            {
                sum2 = sum2 + num;
            }
        }
        if(sum1>total-sum1 || sum2 >total-sum2)
        {
            return true;
        }
     return false;
        
        
    }
}