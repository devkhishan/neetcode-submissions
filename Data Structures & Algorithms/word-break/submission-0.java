class Solution {
    private boolean helper(int ind, int start, String s, Set<String> dict, int[][] dp) {
        // base 
        if (ind == s.length()) return start == s.length();

        if (dp[ind][start] != -1) return dp[ind][start] == 1;

        // take 
        boolean take = false;
        if (dict.contains(s.substring(start, ind+1))) {
            take = helper(ind+1, ind+1, s, dict, dp);
        }

        // notTake
        boolean notTake = helper(ind+1, start, s, dict, dp);

        boolean ans = take || notTake;
        dp[ind][start] = ans ? 1 : 0;
        return ans;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] i : dp) Arrays.fill(i, -1);

        for (int i = 0; i < n; i++) {
            
        }
        return helper(0, 0, s, new HashSet<>(wordDict), dp);
    }
}