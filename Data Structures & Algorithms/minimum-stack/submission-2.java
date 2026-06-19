class MinStack {
    record Pair(int val, int min) {}
    Stack<Pair> stack;
   
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(new Pair(val, !stack.isEmpty() ? Math.min(stack.peek().min(), val) : val));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val();
    }
    
    public int getMin() {
        return stack.peek().min();
    }
}
