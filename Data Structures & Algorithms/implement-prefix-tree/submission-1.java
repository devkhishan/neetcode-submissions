class PrefixTree {
    PrefixTree[] alpha;
    boolean isEnd;
    public PrefixTree() { 
        alpha = new PrefixTree[26];
    }
    
    public void insert(String word) {
        PrefixTree temp = this;
        for(char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (temp.alpha[i]  == null) temp.alpha[i] = new PrefixTree();
            temp = temp.alpha[i];
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        PrefixTree temp = this;
        for(char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (temp.alpha[i] == null) return false;
            temp = temp.alpha[i];
        }
        return temp.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        PrefixTree temp = this;
        for(char ch : prefix.toCharArray()) {
            int i = ch - 'a';
            if (temp.alpha[i] == null) return false;
            temp = temp.alpha[i];
        }
       return true;
    }
}

/**
 * Your PrefixTree object will be instantiated and called as such:
 * PrefixTree obj = new PrefixTree();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */