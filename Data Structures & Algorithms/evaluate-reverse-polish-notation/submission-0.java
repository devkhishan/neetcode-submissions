class Solution {
    public int evalRPN(String[] tokens) {
        var stack = new Stack<Integer>();
        int right, left;
        for(String token : tokens) {
            switch (token) {
                case "+":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left + right);
                    break;
                case "-":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left - right);
                    break;
                case "*":
                    right = stack.pop();
                    left = stack.pop(); 
                    stack.push(left * right);
                    break;
                case "/":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left/right);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
}
