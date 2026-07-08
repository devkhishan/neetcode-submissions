class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for(int i : nums) {

            que.add(i);
            if (que.size() > k) que.poll();
        }

        return que.poll();
    }
}
