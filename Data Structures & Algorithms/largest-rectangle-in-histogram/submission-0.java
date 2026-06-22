class Solution {
    public int largestRectangleArea(int[] heights) {
        //[7,1,7,2,2,4]
        int n = heights.length;
        Stack<int[]> stack = new Stack<>();
        int ans = 0;
        for (int curr = 0; curr < n; curr++) {
            int[] top = null;
            while (!stack.isEmpty() && stack.peek()[1] > heights[curr]) {
                top = stack.pop();
                ans = Math.max(top[1] * (curr-top[0]), ans);
            }

            stack.push(new int[]{top!=null ? top[0] : curr, heights[curr]});
        }

        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            ans = Math.max(ans, top[1] * (n-top[0]));
        }

        return ans;
    }
}
