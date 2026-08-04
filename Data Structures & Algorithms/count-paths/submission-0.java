class Solution {
    private int helper(int r, int c, int m, int n, Integer[][] memo) {
        if (r >= m || c >= n) return 0;
        if (r == m-1 && c == n-1) return 1; 

        if (memo[r][c] != null) return memo[r][c];
        // move right 
        int right =  helper(r, c+1, m, n, memo);
        // move down 
        int down = helper(r+1, c, m, n, memo);

        return memo[r][c] = right + down;
    }
    public int uniquePaths(int m, int n) {
        int[] memo = new int[n+1];
        int[] next = new int[n+1];

        memo[n-1] = 1;

        for(int i=m-1;i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i == m-1 && j == n-1) {
                    continue;
                }
                memo[j] += memo[j+1];
            }
        }
        return memo[0];
    }
}