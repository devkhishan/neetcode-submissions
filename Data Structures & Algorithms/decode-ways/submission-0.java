class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp = 0, dp1 = 1, dp2 = 0;

        for(int i = n-1; i>= 0; i--) {
            if (s.charAt(i) == '0') dp = 0;
            else {
                dp = dp1;
                if (i < n-1) {
                    if (s.charAt(i) == '1' || (s.charAt(i)=='2' && s.charAt(i+1) < '7')) {
                        dp += dp2;
                    }
                }
            }
            dp2 = dp1;
            dp1 = dp;
        }

        return dp;
    }
}