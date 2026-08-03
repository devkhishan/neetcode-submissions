class Solution {
    private int helper(int ind, int target, int[] coins, int[][] dp) {
       
        if (ind == 0) {
            if (target % coins[ind] == 0) {
                return target/coins[ind];
            } else {
                return (int)1e9;
            }
        }

        if (dp[ind][target] != -1) return dp[ind][target];
         // notTake
        int notTake = helper(ind-1, target, coins, dp); 

        // take 
        int take = Integer.MAX_VALUE;
        if ((target - coins[ind])>=0)
            take = 1 + helper(ind, target - coins[ind], coins, dp);

       

        return dp[ind][target] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        
                // base case 
        for(int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0) {
                dp[0][t] = t / coins[0]; 
            } else {
                dp[0][t] = (int)1e9;
            }
        }

        for(int i = 1; i < n; i++) {
            for (int t = 0; t <= amount; t++) {
                int notTake = dp[i-1][t];

                int take = Integer.MAX_VALUE;
                if ((t-coins[i]) >= 0) {
                    take = 1 + dp[i][t-coins[i]];
                }

                dp[i][t] = Math.min(take, notTake);
            }
        }

        return dp[n-1][amount] >= (int)1e9 ? -1 : dp[n-1][amount];
    }
}
