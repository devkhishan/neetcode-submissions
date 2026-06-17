class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int macs_l = height[l], macs_r = height[r];
        int ans = 0;
        while (l<=r) {
            if (macs_l <= macs_r) {
                ans += Math.max(0,Math.min(macs_l, macs_r) - height[l]);
                macs_l = Math.max(macs_l, height[l]);
                l++;
            } else {
                ans += Math.max(0,Math.min(macs_l, macs_r) - height[r]);
                macs_r = Math.max(macs_r, height[r]);
                r--;
            }
        }
        return ans;
    }
}
