class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for(int i : nums) que.add(i);

        while (k-- > 1) que.poll();
        return que.poll();
    }
}
