class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1_n = s1.length();
        int s2_n = s2.length();

        if (s2_n < s1_n) return false;

        int[] s2_hmap = new int[26];
        int[] s1_hmap = new int[26];
        
        for(char ch : s1.toCharArray()) s1_hmap[ch-'a']++;

        // initial load
        int l = 0, r = 0;
        while (r < s1_n) {
            s2_hmap[s2.charAt(r)-'a']++;
            r++;
        }

        while (r < s2_n) {
            if (Arrays.equals(s1_hmap, s2_hmap)) return true;
            s2_hmap[s2.charAt(l++)-'a']--;
            s2_hmap[s2.charAt(r++)-'a']++;
        }

        return Arrays.equals(s1_hmap, s2_hmap);
    }
}
