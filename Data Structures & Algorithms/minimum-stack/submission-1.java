class MinStack {
    record Pair(int val, int min) {}
    Stack<Pair> stack;
    int min;
   
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        stack.push(new Pair(val, min));
    }
    
    public void pop() {
        stack.pop();
        if (!stack.isEmpty()) min = stack.peek().min();
        else min = Integer.MAX_VALUE;
    }
    
    public int top() {
        return stack.peek().val();
    }
    
    public int getMin() {
        return stack.peek().min();
    }
}
