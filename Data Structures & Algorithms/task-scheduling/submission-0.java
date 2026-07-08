class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        int[] alpha = new int[26]; 
        for(char ch : tasks) alpha[ch-'A']++;
        for(int i : alpha) if (i>0) pq.add(i);
        Queue<int[]> q = new LinkedList<>();

        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {
            time += 1;

            if (!pq.isEmpty()) {
                int cnt = pq.poll()-1;
                if (cnt > 0) {
                    q.add(new int[]{cnt, time + n});
                }
            }

            if (!q.isEmpty()) {
                if (q.peek()[1] == time) {
                    pq.add(q.poll()[0]);
                }
            }
        }

        return time;
    }
}
