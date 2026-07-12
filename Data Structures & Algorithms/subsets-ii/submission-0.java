class Solution {
    Set<List<Integer>> set;
    public void subsets(int ind, List<Integer> curr, int[] nums, List<List<Integer>> res) {
        if (ind == nums.length) {
            if (!set.contains(curr)) {
                List<Integer> adder = new ArrayList<>(curr);
                set.add(adder);
                res.add(adder);
            }
            return;
        }

        // take 
        curr.add(nums[ind]);
        subsets(ind+1, curr, nums, res);
        curr.remove(curr.size()-1);

        // notTake
        subsets(ind+1, curr, nums, res);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        set = new HashSet<>();
        Arrays.sort(nums);
        subsets(0, curr, nums, res);
        return res;
    }
}