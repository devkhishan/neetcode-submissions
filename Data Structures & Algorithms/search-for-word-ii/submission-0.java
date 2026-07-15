class Solution {
    private static class Trie {
        Trie[] childrens;
        boolean isWord;
        Trie() {
            childrens = new Trie[26];
        }
    }

    private void search(int r, int c, char[][] board, int rows, int cols, boolean[][] visited, Trie trie, StringBuilder s, List<String> res) {
        
        if (visited[r][c]) return;

        int i = board[r][c] - 'a';
        if (trie.childrens[i] == null) return;

        visited[r][c] = true;
        s.append(board[r][c]);

        if (trie.childrens[i].isWord) {
            res.add(s.toString());
            trie.childrens[i].isWord = false;
        }

        int[] dir = new int[]{-1,0,1,0,-1};
        for(int j=0;j<4;j++) {
            int tr = r + dir[j];
            int tc = c + dir[j+1];
            if (tr >= 0 && tc >= 0 && tr < rows && tc < cols) {
                search(tr,tc, board, rows, cols, visited, trie.childrens[i],s, res); 
            }
        }     
        s.setLength(s.length()-1);   
        visited[r][c] = false;
    }

    private void addWord(String word, Trie trie) {
        for(char ch : word.toCharArray()) {
            int i = ch-'a';
            if (trie.childrens[i] == null) trie.childrens[i] = new Trie();
            trie = trie.childrens[i];
        }
        trie.isWord = true;
    }
    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Trie trie = new Trie();
        StringBuilder s = new StringBuilder();
        List<String> res = new ArrayList<>();

        for(String word : words) addWord(word, trie);

        for(int r=0;r<rows;r++) {
            for (int c = 0; c < cols; c++) {
                search(r, c, board, rows, cols, visited, trie, s, res);
            }
        }

        return res;
    }
}