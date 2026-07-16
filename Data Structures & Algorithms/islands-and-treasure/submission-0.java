class Solution {
    public void swap(int r, int c, int[][] grid, int rows, int cols, int count) {
        int[] dir = new int[]{-1,0,1,0,-1};
        for(int i=0;i<4;i++) {
            int tr = r + dir[i];
            int tc = c + dir[i+1];
            if (tr >= 0 && tr < rows && tc >= 0 && tc < cols && grid[tr][tc]>count) {
                grid[tr][tc] = Math.min(grid[tr][tc],count);
                swap(tr,tc, grid, rows, cols, count+1);
            }
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for(int r=0;r<rows;r++) {
            for(int c=0;c<cols;c++) {
                if (grid[r][c] == 0) {
                    swap(r,c,grid,rows,cols, 1);
                }
            }
        }
    }
}
