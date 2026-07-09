class Solution {
    public void permutations(int ind, int[] nums, List<Integer> hold, List<List<Integer>> res) {
        if (ind == nums.length) {
            res.add(hold);
            return;
        }

        for(int i=0;i<ind+1;i++) {
            List<Integer> temp = new ArrayList<>(hold); 
            temp.add(i,nums[ind]);
            permutations(ind+1, nums, temp, res);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
   

        permutations(0, nums, new ArrayList<>(), res);
        return res;
    }
}