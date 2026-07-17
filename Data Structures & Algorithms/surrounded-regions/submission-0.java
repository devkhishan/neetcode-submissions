class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
    
        for(int c=0;c<cols;c++) {
            if (!visited[0][c] && board[0][c] == 'O') {
                dfs(0, c, board, rows, cols, visited);
            }
            if (!visited[rows-1][c] && board[rows-1][c] == 'O') {
                dfs(rows-1, c, board, rows, cols, visited);
            }
        }
 
        for(int r=0;r<rows;r++) {
            if (!visited[r][0]&& board[r][0] == 'O') {
                dfs(r,0, board, rows, cols, visited);
            }
            if (!visited[r][cols-1]&& board[r][cols-1] == 'O') {
                dfs(r, cols-1, board, rows, cols, visited);
            }
        }

        for(int r=0;r<rows;r++) {
            for(int c=0;c<cols;c++) {
                if (!visited[r][c] && board[r][c] == 'O') board[r][c] = 'X'; 
            }
        }
    }

    public void dfs(int r, int c, char[][] board, int rows, int cols, boolean[][] visited) {
        if (visited[r][c]) return;
        visited[r][c] = true;

        int[] dir = new int[]{-1,0,1,0,-1};
        for(int i=0;i<4;i++) {
            int tr = r + dir[i];
            int tc = c + dir[i+1];
            if (tr>=0 && tc>=0 && tr<rows && tc<cols && board[tr][tc] == 'O' && !visited[tr][tc]){
                dfs(tr, tc, board,rows, cols, visited);
            }
        }
    }
}