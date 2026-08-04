class Solution {
    public List<Integer> findMissingElements(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        int min = arr[0];
        int max = arr[n-1];
        int idx = 0;
        for(int i = min ; i<=max; i++)
        {
            int count = i;
             if(idx<n && arr[idx]==i)
             {
                idx++;
             }
             else
             {
                ans.add(i);
             }
        }
        return ans;
        
    }
}