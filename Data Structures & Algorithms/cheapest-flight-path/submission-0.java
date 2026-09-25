class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);

        prices[src] = 0;
       
        for (int i = 0; i <= k; i++) {
            int[] temp = prices.clone();
            for (int[] path : flights) {
                int s = path[0];
                int d = path[1];
                int price = path[2];

                if (prices[s] == Integer.MAX_VALUE) continue;
                if (prices[s] + price < temp[d]) {
                    temp[d] = prices[s] + price;
                }
            }
            prices = temp;
        }
        return (prices[dst]==Integer.MAX_VALUE) ? -1 : prices[dst];
    }
}