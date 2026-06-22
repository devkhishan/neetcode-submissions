class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int macs = Arrays.stream(piles).max().getAsInt();
        int mini = 1;
        int tota = Arrays.stream(piles).sum();
        int ans = Integer.MAX_VALUE;
        while ( mini <= macs ) { 
            int mid = mini + (macs - mini) / 2;
            int ht = hoursTaken(piles, mid);
            if (ht <= h) {
                ans = Math.min(ans, mid);
                macs = mid-1;
            }
            else mini = mid+1;
        }
        return ans;
    } 
    public int hoursTaken(int[] piles, int h) {
        int hours = 0;
        for(int i : piles) hours += Math.ceil((double)i/h);
        return hours;
    }
}
