class Solution {

    private boolean inBounds(int r, int c, int rows, int cols) {
        return r >= 0 && c>=0 && r < rows && c < cols;
    }

    private void sunkIsland(int r, int c, char[][] grid) {
        grid[r][c] = '0';
        int[] dir = {-1,0,1,0,-1};
        for(int i = 0; i < 4; ++i) {
            int nr = r + dir[i];
            int nc = c + dir[i+1];

            if (inBounds(nr, nc, grid.length, grid[0].length) && grid[nr][nc] == '1') {
                sunkIsland(nr, nc, grid);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int numberOfIslands = 0;
        for(int r = 0; r < rows; ++r) {
            for(int c = 0; c < cols; ++c) {
                if (grid[r][c] == '1') {
                    numberOfIslands++;
                    sunkIsland(r, c, grid);
                }
            }
        }

        return numberOfIslands;
    }
}
