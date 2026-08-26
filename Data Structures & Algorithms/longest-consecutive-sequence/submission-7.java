class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        
        int macs = 0;
        for (int num : set) {
            int length = 1;
            if (!set.contains(num-1)) {
                while (set.contains(num+1)) {
                    length++;
                    num++;
                }
            }
            macs = Math.max(macs, length);
        }

        return macs;
       
    }
}
