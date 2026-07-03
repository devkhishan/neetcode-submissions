class KthLargest {
    private PriorityQueue<Integer> que;
    private int k;
    public KthLargest(int k, int[] nums) {
        que = new PriorityQueue<>();
        this.k = k;
        Arrays.stream(nums).forEach(this::add);
    }
    
    public int add(int val) {
        que.offer(val);
        if (que.size() > k) que.poll();
        return que.peek();
    }
}
