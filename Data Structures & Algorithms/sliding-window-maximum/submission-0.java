class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer,Integer> tmap = new TreeMap<>((a,b) -> Integer.compare(b,a));

        int n = nums.length;
        int[] res = new int[n-k+1];
        int l = 0, r = k;
        // initial load 
        
        for(int i=0;i<r;i++) tmap.merge(nums[i],1,Integer::sum);
        

        res[l] = tmap.firstKey();

        while (r<n) {
            tmap.compute(nums[l++], (x,v) -> v-1 == 0 ? null : v-1);
            tmap.merge(nums[r++], 1, Integer::sum);
            res[l] = tmap.firstKey();
        }

        return res;

    }
}
