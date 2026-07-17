class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] dir = new int[]{-1,0,1,0,-1};
        int[][] updated = new int[rows][cols];
        int freshOranges = 0;
        int time = 0;

        Queue<int[]> que = new LinkedList<>();

        for(int r=0;r<rows;r++) {
            for(int c=0;c<cols;c++) {
                int val = grid[r][c];
                if (val == 2) {
                    updated[r][c] = 2;
                    que.add(new int[]{r,c,0});
                }
                else if (val == 1) freshOranges++;
            }
        }

        while (!que.isEmpty()) {
            int[] curr = que.poll();
            int t = curr[2];
            time = Math.max(time, t);
            for(int i=0;i<4;i++) {
                int r = curr[0] + dir[i];
                int c = curr[1] + dir[i+1];
                
                if (r>=0 && c>=0 && r<rows && c<cols && updated[r][c]==0 && grid[r][c] == 1) {
                    updated[r][c] = 2; 
                    freshOranges--;
                    que.add(new int[]{r,c,t+1});
                }
            }
        }

        return (freshOranges > 0) ? -1 : time;
    }
}
