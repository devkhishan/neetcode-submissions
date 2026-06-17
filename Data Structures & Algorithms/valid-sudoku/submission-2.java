class Solution {
    public boolean isValidSudoku(char[][] board) {
        record Pair(int a, int b){};
        var gridMap = new HashMap<Pair,Set<Character>>();
        for(int i=0;i<9;i++) {
            var rowSet = new HashSet<Character>();
            var colSet = new HashSet<Character>();
            for(int j=0;j<9;j++) {
                if (board[i][j] != '.') {
                    // check row
                    if (rowSet.contains(board[i][j])) {
                        return false;
                    }
                    rowSet.add(board[i][j]);
                    
                    // check grid
                    Pair key = new Pair(i/3, j/3);
                    Set<Character> valueSet = gridMap.computeIfAbsent(key, k -> new HashSet<>());
                    if (!valueSet.add(board[i][j])) {
                        return false;
                    }
                    
                }
                // check col
                if (board[j][i] != '.') {
                    if (colSet.contains(board[j][i])) {
                        return false;
                    }
                    colSet.add(board[j][i]);
                }
                

            }
            
        }
        return true;
    }
}
