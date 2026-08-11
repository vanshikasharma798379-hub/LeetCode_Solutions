class Solution {
    public int missingInteger(int[] arr) {
        int n = arr.length;
        int sum = arr[0];
        for(int i =1; i<n; i++)
        {
            if(arr[i]==arr[i-1]+1)
            {
                sum =sum+arr[i];
            }
            else{
                break;
            }
        }
        while(true)
        {
            int found =-1;
            for(int i =0; i<n; i++)
            {
                if(arr[i]==sum){
                found = 1;
                break;}
            }
            if(found == -1)
            {
                 return sum;
            }
            sum++;
        }
       

        
    }
}