class Solution {
    public void recurse(int ind, int[] nums, List<Integer> curr, List<List<Integer>> res, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (ind == nums.length) return;

        // take
        if (target >= nums[ind]) {
            curr.add(nums[ind]);
            recurse(ind, nums, curr, res, target-nums[ind]);
            curr.remove(curr.size()-1);
        }
        
        // notTake
        recurse(ind+1, nums, curr, res, target);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        recurse(0, candidates, curr, res, target);
        return res;
    }
}