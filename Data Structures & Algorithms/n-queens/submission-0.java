class Solution {
    private boolean isSafe(int r, int c, char[][] board) {
        int tr = r, tc = c;

        // check upwards 
        while (r>=0 && c>=0) if (board[r--][c--] == 'Q') return false;

        // check left
        r = tr;
        c = tc;
        while (c>=0) if (board[r][c--] == 'Q') return false;

        // check downwards
        r = tr;
        c = tc;
        while (r<board.length && c>=0) if (board[r++][c--] == 'Q') return false;

        return true;
    }
    public void solve(int c, char[][] board, List<List<String>> answer, int[] vRows, int[] vLowerDiagonal, int[] vUpperDiagonal) {
        int n = board.length;
        if (c == board[0].length) {
            answer.add(Arrays.stream(board).map(row -> new String(row)).toList());
            return;
        }
        for(int r=0;r<board.length;r++) {
            if (vRows[r]==0 && vLowerDiagonal[r+c] == 0 && vUpperDiagonal[n-1 + c - r]==0) {
                vRows[r]=1;
                vLowerDiagonal[r+c] = 1;
                vUpperDiagonal[n-1+c-r] = 1;
                board[r][c] = 'Q';
                solve(c+1, board, answer, vRows, vLowerDiagonal, vUpperDiagonal);
                board[r][c] = '.';
                vRows[r]=0;
                vLowerDiagonal[r+c] = 0;
                vUpperDiagonal[n-1+c-r] = 0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row : board) Arrays.fill(row, '.');
        int[] vRow = new int[n];
        int[] vLowerDiagonal = new int[2 * n - 1];
        int[] vUpperDiagonal = new int[2 * n - 1];
        solve(0, board, answer, vRow, vLowerDiagonal, vUpperDiagonal);
        return answer;
    }
}