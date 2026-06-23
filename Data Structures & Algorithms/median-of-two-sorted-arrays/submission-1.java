class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;

        int[] a, b;
        if (nums1.length < nums2.length) {
            a = nums1;
            b = nums2;
        } else {
            b = nums1;
            a = nums2;
        }

        int l = 0, r = a.length;

        while (l<=r) {
            int i = (l + r) / 2;
            int j = half - i;

            int aleft = i>0 ? a[i-1] : Integer.MIN_VALUE;
            int aright = (i) < a.length ? a[i] : Integer.MAX_VALUE;
            int bleft = j > 0 ? b[j-1] : Integer.MIN_VALUE;
            int bright = (j) < b.length ? b[j] : Integer.MAX_VALUE;

            if (aleft <= bright && bleft <= aright) {
                if (total%2==0)
                    return (double)(Math.max(aleft,bleft) + Math.min(aright,bright))/2.0;
                return Math.max(aleft,bleft);
            } else if (aleft > bright) {
                r = i-1;
            }
            else {
                l = i + 1;
            }
        }

        return -1;
    }
}
