class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());

        for(int[] pre : prerequisites) {
            indegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }

        int[] topo = new int[numCourses];
        int ind = 0;
        Queue<Integer> que = new LinkedList<>();

        for(int i=0;i<numCourses;i++) if (indegree[i] == 0) que.add(i);

        while(!que.isEmpty()) {
            topo[ind++] = que.poll();
            for(int neighbor : adj.get(topo[ind-1])) {
                indegree[neighbor]--;
                if (indegree[neighbor]==0) que.add(neighbor);
            }
        }

        return (ind == topo.length) ? topo : new int[0];
    }
}