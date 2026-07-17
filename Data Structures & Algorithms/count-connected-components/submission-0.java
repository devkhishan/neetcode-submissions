class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        int[] vis = new int[n];

        for(int i=0;i<n;i++) {
            if (vis[i]!=1) {
                dfs(i, adj, vis, -1);
               
                count++;
            }
        }

        return count;
    }
    public void dfs(int n, List<List<Integer>> adj, int[] vis, int parent) {
        if (vis[n] == 1) return;
        vis[n] = 1;
        for(int neighbor : adj.get(n)) {
            if (neighbor != parent) {
                dfs(neighbor, adj, vis, n);
            }
        }
    }
}
