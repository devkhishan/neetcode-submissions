class Solution {
    public boolean isValidSudoku(char[][] board) {
     
        for(int i=0;i<9;i++) {
            var rowSet = new HashSet<Character>();
            var colSet = new HashSet<Character>();
            for(int j=0;j<9;j++) {
                // check row
                if (board[i][j] != '.') {
                    if (rowSet.contains(board[i][j])) {
                        return false;
                    }
                    rowSet.add(board[i][j]);
                }
                // check col
                if (board[j][i] != '.') {
                    if (colSet.contains(board[j][i])) {
                        return false;
                    }
                    colSet.add(board[j][i]);
                }
                // check grid
                if (i%3==0 && j%3==0) {
                    var gridSet = new HashSet<Character>();
                    for(int m=i;m<i+3;m++) {
                        for(int n=j;n<j+3;n++) {
                            if (board[m][n]!='.') {
                                if (gridSet.contains(board[m][n])) {
                                    return false;
                                }
                                gridSet.add(board[m][n]);
                            }
                        }
                    }
                }

            }
            
        }
        return true;
    }
}
