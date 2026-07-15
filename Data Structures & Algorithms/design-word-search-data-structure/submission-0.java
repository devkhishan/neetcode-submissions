class Trie {
    Trie[] alpha;
    boolean isEnd;
    Trie() {
        alpha = new Trie[26];
    }
}
class WordDictionary {
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie temp = root;
        for(char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (temp.alpha[i] == null) temp.alpha[i] = new Trie();
            temp = temp.alpha[i];
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie temp = root;
        return search(0, word, temp);
    }

    private boolean search(int ind, String word, Trie temp) {
        if (ind == word.length()) {
            return temp.isEnd;
        }
        
        boolean answer = false;
        if (word.charAt(ind) == '.') {
            for(int i=0;i<26;i++) {
                if (temp.alpha[i] != null && search(ind+1, word, temp.alpha[i])) {
                    answer = true; 
                    break;
                }
            }
        } else if (temp.alpha[word.charAt(ind) - 'a'] != null) {
            answer = search(ind+1, word, temp.alpha[word.charAt(ind) - 'a']);
        }
        return answer;
    }
}


