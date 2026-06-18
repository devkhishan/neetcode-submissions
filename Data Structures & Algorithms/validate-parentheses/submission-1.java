class Solution {
    public boolean isValid(String s) {
        var stack = new Stack<Character>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') stack.add(ch);
            else if (!stack.isEmpty()) {
                switch (ch) {
                    case ')':
                        if (stack.peek()!='(') return false;
                        stack.pop();
                        break;
                    case ']':
                        if (stack.peek()!='[') return false;
                        stack.pop();
                        break;
                    case '}':
                        if (stack.peek()!='{') return false;
                        stack.pop();
                        break;
                }
            } else return false;
        }
        return stack.size() == 0;
    }
}
