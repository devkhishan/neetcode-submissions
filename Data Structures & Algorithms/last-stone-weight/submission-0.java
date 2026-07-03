class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> que = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int stone : stones) que.add(stone);

        while (que.size() > 1) {
            int s1 = que.poll();
            int s2 = que.poll();
            
            que.add(s1 < s2 ? (s2-s1) : (s1-s2));
        }

        return (que.size()==1) ? que.poll() : 0;
    }
}
