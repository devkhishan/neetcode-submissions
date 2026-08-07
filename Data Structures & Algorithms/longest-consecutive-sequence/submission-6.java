class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                arr.add(num);
            }
        }
        int count = 1;
        int macs = 0;
        for (int i = 0; i < arr.size(); i++) {
            int temp = arr.get(i);
            if (!set.contains(temp - 1)) {
                count = 1;
              

                while (set.contains(temp + 1)) {
                    count += 1;
                    temp += 1;
                }
                macs = Math.max(macs, count);
            }
        }
        return macs;
    }
}
