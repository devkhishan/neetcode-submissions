class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];

        dp[n] = true;

        for(int i=n-1;i>=0;i--) {
            for (int j = i+1; j <= n; j++) {
                String pref = s.substring(i, j); 
                if (dict.contains(pref) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }

        }

        return dp[0];
    }
}
