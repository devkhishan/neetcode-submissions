class Solution {
    private boolean inBound(int r, int c, int rows, int cols) {
        return r >= 0 && c >= 0 && r < rows && c < cols;
    }
    private boolean find(int r, int c, String word, char[][] board, int ind) {
        // base cases
        if (ind == word.length())
            return true;

        if (!inBound(r, c, board.length, board[0].length)) {
            return false;
        }

        if (board[r][c] != word.charAt(ind)) return false;

        board[r][c] = '#';

        int[] dir = {-1, 0, 1, 0, -1};
        for (int i = 0; i < 4; ++i) {
            int nr = r + dir[i];
            int nc = c + dir[i + 1];
            if (find(nr, nc, word, board, ind + 1)) {
                return true;
            }
        }

        board[r][c] = word.charAt(ind);
        return false;
    }
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0 || board == null || board.length == 0)
            return false;

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                if (board[r][c] == word.charAt(0) && find(r, c, word, board, 0)) {
                    return true;
                }
            }
        }

        return false;
    }
}
