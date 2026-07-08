class MedianFinder {
    PriorityQueue<Integer> small, large;
    public MedianFinder() {
        small = new PriorityQueue<>((a,b) -> b-a);
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.add(num);
        if (
            small.size() - large.size() > 1 ||
            !large.isEmpty() &&
            small.peek() > large.peek()
        ) 
        large.add(small.poll());

        if (large.size() - small.size() > 1) {
            small.add(large.poll());
        }
    }
    
    public double findMedian() {
        int slen = small.size();
        int llen = large.size();
        double res = 0;
       
        if (slen == llen) res = (double) (small.peek() + large.peek()) / 2.0;
        else if (slen > llen) res = small.peek();
        else res = large.peek();
        
        return res;
    }
}
