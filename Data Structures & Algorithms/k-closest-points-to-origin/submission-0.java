class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> {
            int distA = a[0]*a[0] + a[1]*a[1];
            int distB = b[0]*b[0] + b[1]*b[1];
            return Integer.compare(distA, distB);
        });

        for(int[] point : points) que.add(point);

        int[][] res = new int[k][2];
     
        while (k>0) res[res.length-k--] = que.poll();
        return res;
    }
}
