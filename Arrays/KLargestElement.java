import java.util.Arrays;
class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        ArrayList<Integer> ans= new ArrayList<>();
       int n = arr.length;
       Arrays.sort(arr);
       for(int i =n-1; i>=n-k; i--)
       {
           ans.add(arr[i]);
       }
       return ans;
    }
}
