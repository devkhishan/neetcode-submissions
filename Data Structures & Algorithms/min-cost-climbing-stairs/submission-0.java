class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int a = 0, b = cost[0];
        for(int i=1; i<n;i++) {
            int temp = b;
            b = cost[i] + Math.min(a, b); 
            a = temp;
        }
        return Math.min(a,b);
    }
}