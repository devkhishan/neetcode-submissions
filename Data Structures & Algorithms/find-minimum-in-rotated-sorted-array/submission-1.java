class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        if (r==0) return nums[0];
        if (nums[l] < nums[r]) return nums[l];

        while (l<=r) {
            int mid = l + (r-l)/2;
            if (nums[mid]>nums[l] || l==mid) {
                if(nums[mid] > nums[mid+1]) return nums[mid+1];
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        return -1;
    }
}
