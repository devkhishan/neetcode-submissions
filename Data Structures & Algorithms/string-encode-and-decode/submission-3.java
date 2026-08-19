class Solution {

    
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append('@');
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while ( i < str.length() ) {

            int j = i;
            StringBuilder jump = new StringBuilder();
            while (j < str.length() && str.charAt(j)!='@') {
                jump.append(str.charAt(j++));
            }

            int end = j + Integer.parseInt(jump.toString()) + 1;
            res.add(str.substring(j + 1, end));
            i = end;
        }

        return res;
    }
}
