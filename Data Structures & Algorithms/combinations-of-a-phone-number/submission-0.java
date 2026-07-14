class Solution {
    public void find(int ind, String digits, StringBuilder s, List<String> res, Map<Integer,String> map) {
        if (ind == digits.length()) {
            if(!s.isEmpty()) res.add (s.toString());
            return;
        }

        int d = digits.charAt(ind) - '0';
        for(char ch : map.get(d).toCharArray()) {
            s.append(ch);
            find(ind+1, digits, s, res, map);
            s.setLength(s.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5, "jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        find(0, digits, s, res, map);
        return res; 
    }
}