class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char ch : t.toCharArray()) countT.merge(ch, 1, Integer::sum);

        int have = 0, need = countT.size();
        int[] res = new int[]{-1,-1};
        int res_len = s.length()+1;
        int l = 0;

        for(int r=0;r<s.length();r++){
            char rightChar = s.charAt(r);
            window.merge(rightChar, 1, Integer::sum);

            if (countT.containsKey(rightChar) && window.get(rightChar).equals(countT.get(rightChar)))
                have++;
            
            while (have == need) {
                if (r-l+1 < res_len) {
                    res_len = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.computeIfPresent(leftChar, (k,v) -> v-1);
                if (countT.containsKey(leftChar) && (countT.get(leftChar) > window.get(leftChar)))
                    have--;
                l++;
            }

        }
        return res_len == s.length() + 1 ? "" : s.substring(res[0], res[1]+1);
    }
}
