class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        boolean[] vis = new boolean[n];
        int total = 0;

        for (int i = 0; i < n; ++i) {
            int u = -1;
            for (int v = 0; v < n; ++v) {
                if (!vis[v] && (u == -1 || minDist[v] < minDist[u])) {
                    u = v;
                }
            }

            vis[u] = true;
            total += minDist[u];

            for (int v = 0; v < n; ++v) {
                if (!vis[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                    if (dist < minDist[v]) {
                        minDist[v] = dist;
                    }
                }
            }

        }
        return total;
    }
}
