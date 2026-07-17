class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer,List<Integer>> adj = new HashMap<>();
       
        int[] indegree = new int[numCourses];

        for(int[] pre : prerequisites) {
            indegree[pre[1]]++;
            adj.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(pre[1]);
        }

        Queue<Integer> que = new LinkedList<>();

        for(int i=0;i<numCourses;i++) {
            if (indegree[i] == 0) que.add(i);
        }

        int count = 0;
        while (!que.isEmpty()) {
            int curr = que.poll();
            count++;
            for (int neighbor : adj.getOrDefault(curr, new ArrayList<>())) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) que.add(neighbor);
            }
        }

        return (count == numCourses);
    }
}