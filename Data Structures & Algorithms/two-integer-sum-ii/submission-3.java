class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length, l = 0, r = n-1;

        while (l<r) {
            int twoSum = numbers[l] + numbers[r];
            if (twoSum > target) r-=1;
            else if (twoSum < target) l+=1;
            else break;
        }
        return new int[]{l+1, r+1};
    }
}
