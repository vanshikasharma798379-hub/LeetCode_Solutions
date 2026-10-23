class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int[] fact = new int[n + 1];
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
            list.add(i);
        }

        k--;

        StringBuilder ans = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            int index = k / fact[i];
            ans.append(list.get(index));
            list.remove(index);
            k %= fact[i];
        }

        return ans.toString();
        
    }
}