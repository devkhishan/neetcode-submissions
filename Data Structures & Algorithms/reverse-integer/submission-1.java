class Solution {
    public int reverse(int x) {
        long res = 0;

        while (x != 0) {
            int unit = x % 10;
            res *= 10;
            res += unit;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }


        return (int) res;
    }
}
