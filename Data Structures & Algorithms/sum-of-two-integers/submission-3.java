class Solution {
    public int getSum(int a, int b) {
        int xor = a ^ b;
        int and = (a & b) << 1;

        while (and != 0) {
            int xor2 = xor ^ and;
            int and2 = (xor & and) << 1;
            xor = xor2;
            and = and2;
        }

        return xor;
    }
}
