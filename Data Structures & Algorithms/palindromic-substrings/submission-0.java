class Solution {
    private int palindrome(int left, int right, String s, int n) {
        int res = 0; 

        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            res++;
            left--;
            right++;
        }

        return res;
    }
    public int countSubstrings(String s) {
        int ans = 0, n = s.length();
        for(int i=0;i<n;i++) {
            ans += palindrome(i, i, s, n) + palindrome(i, i+1, s, n);
        }

        return ans;
    }
}