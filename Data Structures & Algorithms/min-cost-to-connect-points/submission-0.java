class Solution {
    public record Point(int x, int y) {
        public Point(int[] coordinate) {
            this (coordinate[0], coordinate[1]);
        }
        int manhattan(Point other) {
            return Math.abs(other.x() - this.x) + Math.abs(other.y() - this.y);
        }
    }
    public record Pair(int weight, Point point) {}
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Map<Point, List<Pair>> adj = new HashMap<>(); 
        Set<Point> visited = new HashSet<>();

        // create adj
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                Point from = new Point(points[i]);
                Point to = new Point(points[j]);
                adj.computeIfAbsent(from, k -> new ArrayList<>()).add(new Pair(from.manhattan(to), to));
                adj.computeIfAbsent(to, k -> new ArrayList<>()).add(new Pair(to.manhattan(from), from));
            }
        }


        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.weight(), b.weight()));
       

        pq.add(new Pair(0, new Point(points[0])));
        int sum = 0;
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            Point cPoint = curr.point();

            if (visited.contains(cPoint)) continue;
            visited.add(cPoint);

            sum += curr.weight();

            for (Pair nei : adj.getOrDefault(cPoint, Collections.emptyList())) {
                if (!visited.contains(nei.point())) {
                    pq.add(nei);
                }
            }
        }

        return sum;
    }
}