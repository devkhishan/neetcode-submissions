class Solution {

    int[] coins;
    int[][] dp;

    public int change(int amount, int[] coins) {
        this.coins = coins;
        int n = coins.length;

        int[] prev = new int[amount+1];
        int[] curr = new int[amount+1];

        for (int diff = 0; diff <= amount; diff++) {
            prev[diff] = (diff % coins[0] == 0) ? 1 : 0;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int diff = 0; diff <= amount; diff++) {
                int take = 0;
                if (diff - coins[ind] >= 0) take = curr[diff - coins[ind]];
                int notTake = prev[diff];

                curr[diff] = take + notTake;
            }
            prev = curr;
        }
        return prev[amount];
    }
}