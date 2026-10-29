import java.util.*;

class Solution {
    private int[] head, to, next;
    private int[][] lift;
    private int[] first, last, depth;
    private int time, maxPower;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        first = new int[n];
        last = new int[n];
        depth = new int[n];
        maxPower = 31 - Integer.numberOfLeadingZeros(n);
        lift = new int[maxPower + 1][n];

        head = new int[n];
        Arrays.fill(head, -1);

        int m = edges.length;
        to = new int[2 * m];
        next = new int[2 * m];

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            to[2 * i] = v;
            next[2 * i] = head[u];
            head[u] = 2 * i;

            to[2 * i + 1] = u;
            next[2 * i + 1] = head[v];
            head[v] = 2 * i + 1;
        }

        time = 0;
        dfs(0, -1);

        BIT bit = new BIT(n + 1);
        char[] arr = s.toCharArray();

        for (int i = 0; i < n; i++) {
            int mask = 1 << (arr[i] - 'a');
            bit.update(first[i], mask);
            bit.update(last[i] + 1, mask);
        }

        List<Boolean> ans = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split(" ");

            int u = Integer.parseInt(parts[1]);

            if (parts[0].equals("update")) {
                char c = parts[2].charAt(0);

                if (arr[u] == c) {
                    continue;
                }

                int mask = (1 << (arr[u] - 'a')) ^ (1 << (c - 'a'));

                bit.update(first[u], mask);
                bit.update(last[u] + 1, mask);

                arr[u] = c;
            } else {
                int v = Integer.parseInt(parts[2]);
                int ancestor = lca(u, v);

                int mask = bit.query(first[u])
                         ^ bit.query(first[v])
                         ^ (1 << (arr[ancestor] - 'a'));

                ans.add((mask & (mask - 1)) == 0);
            }
        }

        return ans;
    }

    private void dfs(int u, int parent) {
        first[u] = ++time;

        for (int e = head[u]; e != -1; e = next[e]) {
            int v = to[e];

            if (v == parent) {
                continue;
            }

            depth[v] = depth[u] + 1;
            lift[0][v] = u;

            for (int j = 1; j <= maxPower; j++) {
                lift[j][v] = lift[j - 1][lift[j - 1][v]];
            }

            dfs(v, u);
        }

        last[u] = time;
    }

    private int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = maxPower; j >= 0; j--) {
            if ((diff & (1 << j)) != 0) {
                u = lift[j][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int j = maxPower; j >= 0; j--) {
            if (lift[j][u] != lift[j][v]) {
                u = lift[j][u];
                v = lift[j][v];
            }
        }

        return lift[0][u];
    }

    private static class BIT {
        int[] tree;
        int n;

        BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int index, int value) {
            for (int i = index + 1; i <= n; i += i & -i) {
                tree[i] ^= value;
            }
        }

        int query(int index) {
            int result = 0;

            for (int i = index + 1; i > 0; i -= i & -i) {
                result ^= tree[i];
            }

            return result;
        }
    }
}