class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> que = new LinkedList<>();
        int n = nums.length;

        int[] res = new int[n-k+1];

        int l = 0;

        for(int r=0;r<n;r++) {
            while (!que.isEmpty() && nums[r] > nums[que.getLast()]) que.removeLast();
            que.addLast(r);

            if (l > que.getFirst()) que.removeFirst();

            if ((r+1) >= k) {
                res[l] = nums[que.getFirst()];
                l++;
            }
        }
        return res;
    }
}