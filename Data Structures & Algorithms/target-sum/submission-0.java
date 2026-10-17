class Solution {
    private int perfectSum(int[] arr, int K) {
    
        int n = arr.length;
   
        int[] prev = new int[K+1];
        
        prev[0] = (arr[0] == 0) ? 2 : 1;
        if(arr[0] != 0 && arr[0] <= K) prev[arr[0]] = 1;
        
    
        for(int ind = 1; ind < n; ind++) {
            int[] curr = new int[K+1];
            for(int sum = 0; sum <= K; sum++) {
                

                int notTake = prev[sum];
                int take = 0;
                if (arr[ind] <= sum) {
                    take = prev[sum-arr[ind]];
                }

                curr[sum] = (take + notTake);
            }
            prev = curr;
        }

        return prev[K];
    }
    public int countPartitions(int n, int diff, int[] arr) {
        int totalSum = Arrays.stream(arr).sum();

        if (totalSum - diff < 0 || (totalSum - diff) % 2 != 0) return 0;

        return perfectSum(arr, (totalSum - diff) / 2);
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
    
        return countPartitions(n, target, nums);
    }
}