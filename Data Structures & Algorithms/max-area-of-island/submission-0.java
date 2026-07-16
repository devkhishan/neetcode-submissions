class Solution {
    public int sunkIsland(int r, int c, int rows, int cols, int[][] grid) {
        grid[r][c]= 0;
        int[] dir = new int[]{-1,0,1,0,-1};
        int count = 0;
        for(int i=0;i<4;i++) {
            int tr = r + dir[i];
            int tc = c + dir[i+1];
            if (tr >= 0 && tc >= 0 && tr < rows && tc < cols && grid[tr][tc] == 1) {
                count += 1 + sunkIsland(tr, tc, rows, cols, grid);
            }
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int macs = 0;
        for(int r=0;r<rows;r++) {
            for(int c=0;c<cols;c++) {
                if (grid[r][c] == 1) {
                    macs = Math.max(macs,1 + sunkIsland(r,c,rows,cols,grid));
                }
            }
        }
        return macs;
    }
}