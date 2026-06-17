class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int macs_l = height[l], macs_r = height[r];
        int ans = 0;
        while (l<r) {
            if (macs_l < macs_r) {
                l++;
                macs_l = Math.max(macs_l, height[l]);
                ans += macs_l - height[l];
            } else {
                r--;
                macs_r = Math.max(macs_r, height[r]);
                ans += macs_r - height[r];
            }
        }
        return ans;
    }
}
