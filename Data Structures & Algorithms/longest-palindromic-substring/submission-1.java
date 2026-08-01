class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        int resLen = 0;

        for(int i = 0; i < n; i++) {
            // odd length
            int left = i, right = i;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1; 
                if (len > resLen) {
                    res = s.substring(left, right+1);
                    resLen = len;
                }
                left--;
                right++;
            }

            // even length
            left = i;
            right = i+1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1; 
                if (len > resLen) {
                    res = s.substring(left, right+1);
                    resLen = len;
                }
                left--;
                right++;
            }
        }

        return res;
    }
}
