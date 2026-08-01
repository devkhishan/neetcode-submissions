class Solution {
    public int rob(int[] nums) {
        int a = 0, b = nums[0];
        int n = nums.length;

        for(int i = 1; i < n; i++) {
            int temp = b;
            b = Math.max(a + nums[i], b);
            a = temp;
        }

        return Math.max(a,b);
    }
}