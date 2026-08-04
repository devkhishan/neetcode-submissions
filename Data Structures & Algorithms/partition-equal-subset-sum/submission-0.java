class Solution {
    private boolean tSum(int ind, int[] nums, int target, Boolean[][] memo) {
        if (target == 0) return true;
        if (ind == 0) return (target-nums[ind] == 0);

        if (memo[ind][target] != null) return memo[ind][target];
        boolean take = false;
        if (nums[ind] <= target) take = tSum(ind-1, nums, target - nums[ind], memo);

        boolean notTake = tSum(ind-1, nums, target, memo); 

        return memo[ind][target] = take || notTake;

    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false; 

        int target = sum / 2; 
        boolean[] memo = new boolean[target+1];
        boolean[] curr = new boolean[target+1];
        memo[0] = true;
        if (nums[0] <= target) memo[nums[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            for(int tar = 1; tar <= target; tar++) {
                boolean take = false;
                if (nums[ind] <= tar) take = memo[tar - nums[ind]];
                boolean notTake = memo[tar];

                curr[tar] = take || notTake;
            }
            memo = curr.clone();
        }  

        return memo[target];
    }
}