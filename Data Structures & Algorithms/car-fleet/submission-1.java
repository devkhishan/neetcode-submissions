class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pairs = new int[n][2];

        for(int i=0;i<n;i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a,b) -> b[0]-a[0]);

        Stack<int[]> stack = new Stack<>();

        for(int[] pair : pairs) {
            if (stack.isEmpty()) stack.add(pair);
            else {
                int[] top = stack.peek();
                if (((double)(target-top[0])/(double)top[1]) < ((double)(target-pair[0])/(double)pair[1])){
                    stack.push(pair);
                }
            }
        }

        return stack.size();
    }
}
