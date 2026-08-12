class Solution {
    public record Cell(int row, int col, int minutes) {}

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;
        Queue<Cell> que = new ArrayDeque<>();

        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                if (grid[r][c] == 2) {
                    que.add(new Cell(r, c, 0));
                } else if (grid[r][c] == 1) {
                    ++freshCount;
                }
            }
        }    

        if (freshCount == 0) return 0;

        int maxMinutes = 0;
        int[] dir = {-1,0,1,0,-1};
        while (!que.isEmpty()) {
            Cell curr = que.poll();
            
            maxMinutes = Math.max(maxMinutes, curr.minutes());

            for (int i = 0; i < 4; ++i) {
                int nr = curr.row() + dir[i];
                int nc = curr.col() + dir[i+1];

                if (inBound(nr, nc, rows, cols) && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    freshCount--;
                    que.add(new Cell(nr, nc, curr.minutes() + 1));
                } 
            }
            
        }

        return freshCount == 0 ? maxMinutes : -1;
    }

    private boolean inBound(int r, int c, int rows, int cols) {
        return r >= 0 && c >= 0 && r < rows && c < cols;
    }
}
