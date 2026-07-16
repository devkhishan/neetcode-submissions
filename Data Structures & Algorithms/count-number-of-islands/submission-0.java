class Solution {
    public void sunkIsland(int r, int c, char[][] grid, int rows, int cols, boolean[][] visited) {
        if (grid[r][c] == '0' || visited[r][c]) return;
        grid[r][c] = '0';
        int[] dir = new int[]{-1,0,1,0,-1};
        for(int i=0;i<4;i++) {
            int tr = r + dir[i];
            int tc = c + dir[i+1];
            if (tr >= 0 && tc >=0 && tr < rows && tc < cols && grid[tr][tc] == '1' && !visited[tr][tc]) {
                sunkIsland(tr, tc, grid, rows, cols, visited);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[rows][cols];
        for(int r=0;r<rows;r++) {
            for(int c=0;c<cols;c++) {
                if (grid[r][c] == '1') {
                    count++;
                    sunkIsland(r,c,grid, rows, cols, visited);
                }
            }
        }
        return count;
    }
}