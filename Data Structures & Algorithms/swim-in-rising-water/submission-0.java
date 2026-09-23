class Solution {
    record Item(int value, int row, int col){};
    public int swimInWater(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        PriorityQueue<Item> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.value(), b.value()));
        pq.add(new Item(grid[0][0], 0, 0));

        int[] dir = {-1,0,1,0,-1};
        while (!pq.isEmpty()) {
            Item curr = pq.poll();
            int r = curr.row();
            int c = curr.col();

            if (visited[r][c]) continue;
            visited[r][c] = true;

            if (r == rows-1 && c == cols-1) {
                return curr.value();
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i];
                int nc = c + dir[i+1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
                    pq.add(new Item(Math.max(grid[nr][nc], curr.value()), nr, nc));
                }
            }
        }

        return rows * cols;
    }
}