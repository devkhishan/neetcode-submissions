class Solution {
    int[] dir = new int[]{-1,0,1,0,-1};
    public boolean find(int ind, int r, int c, char[][] board, String word, int rows, int cols) {
        // base case 
        if (ind == word.length()-1) return word.charAt(ind) == board[r][c];

        if (word.charAt(ind) == board[r][c]) {
            board[r][c] = '#';
            for(int i=0;i<4;i++) {
                int tr = r + dir[i];
                int tc = c + dir[i+1]; 
                if (tr>=0 && tr<rows && tc>=0 && tc<cols && board[tr][tc]!='#') {
                    boolean answer = find(ind+1, tr,tc, board, word, rows, cols);
                    if (answer) return answer;
                }
            }
            board[r][c] = word.charAt(ind);
        }        
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] visited = new int[rows][cols];

        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++){
                if(find(0, i, j, board, word, rows, cols))
                    return true;
            }
        }
        return false;
    }
}