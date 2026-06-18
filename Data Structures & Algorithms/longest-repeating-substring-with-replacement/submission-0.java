class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] hmap = new int[26];
        int maxf = 0;
        int res = 0;
        int l = 0;
        for(int r=0;r<n;r++){
            maxf = Math.max(maxf, ++hmap[s.charAt(r)-'A']);
            if ((r-l+1 - maxf) <= k) res = Math.max(res, r-l+1);
            else hmap[s.charAt(l++)-'A']--;
        }
        return res;
    }
}
