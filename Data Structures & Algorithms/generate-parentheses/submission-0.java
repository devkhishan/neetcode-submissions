class Solution {
    List<String> res;
    int n;
    public void buildParentheses(StringBuilder paran, int open, int close) {
        if (open==0 && close==0) {
            res.add(paran.toString());
            return;
        }
        int n = paran.length();
        // take open 
        if (open > 0 && close > 0) {
            paran.append("(");
            buildParentheses(paran, open-1, close);
            paran.setLength(n);
        }

        // take close
        if (!paran.isEmpty() && close > 0 && (open<close)) {
            paran.append(")");
            buildParentheses(paran, open, close-1);
            paran.setLength(n);
        }
    }
    public List<String> generateParenthesis(int n) {
        int open = n, close = n;
        this.n = n;
        res = new ArrayList<>();
        StringBuilder paran = new StringBuilder("");
        buildParentheses(paran, open, close);
        return res;
    }
}
