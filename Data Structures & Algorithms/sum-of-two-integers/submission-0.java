class Solution {
    public int getSum(int a, int b) {
        int xor = a ^ b;
        int and = (a & b) << 1;

        while (and != 0) {
            int tmp = xor;
            xor = xor ^ and;
            and = (tmp & and) << 1;
        }

        return xor;
    }
}
