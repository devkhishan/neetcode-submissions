class Solution {
    public boolean isValid(String s) {
        var stack = new Stack<Character>();
        var hmap = Map.of(')','(',']','[','}','{');
        for (char ch : s.toCharArray()) {
            if (hmap.values().contains(ch)) stack.add(ch);
            else if (!stack.isEmpty()) {
                if (stack.peek()!=hmap.get(ch)) return false;
                stack.pop();
            } else return false;
        }
        return stack.size() == 0;
    }
}
