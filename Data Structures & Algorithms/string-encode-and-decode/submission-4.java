class Solution {

    public String encode(List<String> strs) {
        
        StringBuilder res = new StringBuilder();

        for (String str : strs) {
            res.append(str.length()).append("@").append(str);
        }

        return res.toString();
    }

    public List<String> decode(String str) {

        List<String> res = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int j = i;
            StringBuilder num = new StringBuilder();
            while (str.charAt(j) != '@') {
                num.append(str.charAt(j));
                j++;
            }
            int ogNum = Integer.parseInt(num.toString());
            int end = j + ogNum + 1;
            String curr = str.substring(j+1, end);
            res.add(curr);
            i = end;
        }

        return res;
    }
}
