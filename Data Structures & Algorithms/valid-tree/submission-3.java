class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        
        if (!dfs(0, adj, vis, -1)) return false;
        for (boolean v : vis) {
            if (!v) return false;
        }
        return true;
    }

    public boolean dfs(int n, List<List<Integer>> adj, boolean[] vis, int parent) {
        if (vis[n]) return false;
        vis[n] = true;

        for(int neighbor : adj.get(n)) {
            if(neighbor != parent && !dfs(neighbor, adj, vis, n)) {
                return false;
            }
        }
        return true;
    }
}
