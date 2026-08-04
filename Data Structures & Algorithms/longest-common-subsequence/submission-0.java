class Solution {
    public int lcs(int i1, int i2, String t1, String t2, int[][] dp) {
        if (i1 == t1.length() || i2 == t2.length()) return 0;

        if (dp[i1][i2] != -1) return dp[i1][i2];

        if (t1.charAt(i1) == t2.charAt(i2)) {
            return dp[i1][i2] = 1 + lcs(i1 + 1, i2 + 1, t1, t2, dp);
        }

        int s1 = lcs(i1+1, i2, t1, t2, dp);
        int s2 = lcs(i1, i2+1, t1, t2, dp);

        return dp[i1][i2] = Math.max(s1, s2);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1+1][n2+1];

        for(int i = n1-1; i >= 0; i--) {
            for (int j = n2-1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}