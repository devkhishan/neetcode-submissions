class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        Queue<int[]> que = new LinkedList<>();
        int[][] pacificVis = new int[rows][cols];
        int[][] atlanticVis = new int[rows][cols];
        List<List<Integer>> res = new ArrayList<>();
        // pacific Ocean
        for(int c = 1;c<cols;c++) {
            pacificVis[0][c] = 1;
            que.add(new int[]{0,c});
        }
        for(int r = 0;r<rows;r++) {
            pacificVis[r][0] = 1;
            que.add(new int[]{r,0});
        }

        markHigh(que, rows, cols, heights, pacificVis);
    
        // atlantic Ocean
        for(int c=0;c<cols;c++) {
            atlanticVis[rows-1][c] = 1;
            que.add(new int[]{rows-1, c});
        }
        for(int r=0;r<rows-1;r++) {
            atlanticVis[r][cols-1] = 1;
            que.add(new int[]{r,cols-1});
        }

        markHigh(que, rows, cols, heights, atlanticVis);

        for(int r=0;r<rows;r++) {
            for(int c=0; c<cols; c++) {
                if (pacificVis[r][c]==1 && atlanticVis[r][c] == 1) {
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }

    public void markHigh(Queue<int[]> que, int rows, int cols, int[][] heights, int[][] visited) {

        int[] dir = new int[]{-1,0,1,0,-1};
        while(!que.isEmpty()){
            int[] curr = que.poll();
            int r = curr[0];
            int c = curr[1];
            for(int i=0;i<4;i++) {
                int tr = r + dir[i];
                int tc = c + dir[i+1];
                if (tr>=0 && tc>=0 && tr<rows && tc<cols && heights[tr][tc] >= heights[r][c] && visited[tr][tc]!=1) {
                    visited[tr][tc] = 1;
                    que.add(new int[]{tr,tc});
                }
            }
        }
    }
}