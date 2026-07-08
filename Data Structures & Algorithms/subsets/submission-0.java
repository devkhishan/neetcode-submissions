class Solution {
    int n;
    List<List<Integer>> res;
    int[] nums;
    public void recurse(int ind, List<Integer> curr) {
        if (ind == n) {
            res.add(new ArrayList<>(curr));
            return;
        }
        // take 
        curr.add(nums[ind]);
        recurse(ind+1, curr);

        // notTake
        curr.remove(curr.size()-1);
        recurse(ind+1, curr);
    }
    public List<List<Integer>> subsets(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        res = new ArrayList<>();
        
        recurse(0, new ArrayList<>());

        return res;
    }
}