class Solution {
    public int helper(int ind, int lei, int[] nums, Integer[][] memo) {
        if (ind == nums.length) return 0;

        if (memo[ind][lei+1] != null) return memo[ind][lei+1];

        int take = 0;
        if (nums[ind] > ((lei==-1) ? Integer.MIN_VALUE : nums[lei])) {
            take = 1 + helper(ind+1, ind, nums, memo);
        }

        int notTake = helper(ind+1, lei, nums, memo);

        return memo[ind][lei+1] = Math.max(take, notTake);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n+1]; 
        int[] curr = new int[n+1];
        int res = 0;
        

        for (int i = n-1; i >= 0; i--) {
            for (int j = i-1; j >= -1; j--) {
                int take = 0;
                if (nums[i] > ((j == -1) ? Integer.MIN_VALUE : nums[j])) {
                    take = 1 + memo[i+1];
                }

                int notTake = memo[j+1];

                curr[j+1] = Math.max(take, notTake);
            }
            memo = curr;
            curr = new int[n+1];
        }
        return memo[0];
    }
}