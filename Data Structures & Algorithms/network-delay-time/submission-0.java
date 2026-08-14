class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // create adj from edges
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++) adj.add(new ArrayList<>());

        Set<Integer> visited = new HashSet<>();
        for(int[] time : times) {
            adj.get(time[0]).add(new Pair(time[1], time[2]));
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> a.getKey() - b.getKey());
        pq.add(new Pair<>(0, k));
        

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> curr = pq.poll();
            dist[curr.getValue()] = Math.min(dist[curr.getValue()], curr.getKey());
            
            if (visited.contains(curr.getValue())) continue;
            visited.add(curr.getValue());
            
            for(Pair<Integer, Integer> nei : adj.get(curr.getValue())) {
                pq.add(new Pair<>(curr.getKey() + nei.getValue(), nei.getKey()));
            }
        }
        
        int macs = -1;
        for(int i=1;i<=n;i++) macs = Math.max(macs, dist[i]);
        return macs == Integer.MAX_VALUE ? -1 : macs;
    }
}