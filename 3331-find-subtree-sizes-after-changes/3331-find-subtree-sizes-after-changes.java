import java.util.*;
class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        ArrayList<Integer>[] children = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }
        int[] nearest = new int[26];
        Arrays.fill(nearest, -1);
        int[] newParent = new int[n];
        int[] old = new int[n];
        int[] stack = new int[2 * n];
        int top = 0;
        stack[top++] = 1;
        while (top > 0) {
            int event = stack[--top];
            if (event < 0) {
                int node = -event - 1;
                nearest[s.charAt(node) - 'a'] = old[node];
            } else {
                int node = event - 1;
                int c = s.charAt(node) - 'a';
                old[node] = nearest[c];
                if (nearest[c] != -1) {
                    newParent[node] = nearest[c];
                } else {
                    newParent[node] = parent[node];
                }
                nearest[c] = node;
                stack[top++] = -(node + 1);
                for (int child : children[node]) {
                    stack[top++] = child + 1;
                }
            }
        }

        ArrayList<Integer>[] newChildren = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            newChildren[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            newChildren[newParent[i]].add(i);
        }

        int[] order = new int[n];
        top = 0;
        int count = 0;

        stack[top++] = 0;

        while (top > 0) {

            int node = stack[--top];

            order[count++] = node;

            for (int child : newChildren[node]) {
                stack[top++] = child;
            }
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        for (int i = n - 1; i >= 0; i--) {

            int node = order[i];

            if (newParent[node] != -1) {
                ans[newParent[node]] += ans[node];
            }
        }

        return ans;
    }
}