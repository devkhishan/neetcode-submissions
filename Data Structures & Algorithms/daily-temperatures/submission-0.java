class Solution {
    record Pair(int val, int ind) {}
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        int ind = 0;
        Stack<Pair> stack = new Stack<>(); 
        
        for(int i=0;i<n;i++) {
            while (!stack.isEmpty() && temperatures[i] > (stack.peek()).val()) {
                Pair top = stack.peek();
                res[top.ind()] = i - top.ind();
                stack.pop();
            }
            stack.push(new Pair(temperatures[i], i));
        }

        return res;
    }
}
