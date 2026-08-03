class Solution {
    private int helper(int ind, int target, int[] coins) {
       
        if (ind == 0) {
            if (target % coins[ind] == 0) {
                return target/coins[ind];
            } else {
                return (int)1e9;
            }
        }
         // notTake
        int notTake = helper(ind-1, target, coins); 

        // take 
        int take = Integer.MAX_VALUE;
        if ((target - coins[ind])>=0)
            take = 1 + helper(ind, target - coins[ind], coins);

       

        return Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int ans = helper(coins.length - 1, amount, coins);
        return ans >= (int)1e9 ? -1 : ans;
    }
}
