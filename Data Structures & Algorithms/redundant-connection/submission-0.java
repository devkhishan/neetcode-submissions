class Solution {
    private class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n+1];
            rank = new int[n+1];
            for(int i=1;i<=n;i++) parent[i] = i;
        }

        int find(int node) {
            if (parent[node] == node) return node;
            return parent[node] = find(parent[node]);
        }

        boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv) return false;

            if (rank[pu] > rank[pv]) parent[pv] = pu;
            else if (rank[pv] > rank[pu]) parent[pu] = pv;
            else {
                parent[pu] = pv;
                rank[pv]++;
            }
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);
        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return edges[edges.length-1];
    }
}