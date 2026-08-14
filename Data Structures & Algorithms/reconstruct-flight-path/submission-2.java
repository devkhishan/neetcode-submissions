class Solution {
    private void dfs(String key, Map<String, PriorityQueue<String>> adj, LinkedList<String> ans) {

        PriorityQueue<String> neis = adj.get(key);
        
        while (neis != null && !neis.isEmpty()) {
            String nei = neis.poll();
            dfs(nei, adj, ans);
        }

        ans.addFirst(key);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
       
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        LinkedList<String> ans = new LinkedList<>();

        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        dfs("JFK", adj, ans);
        
        return ans;
    }
}
