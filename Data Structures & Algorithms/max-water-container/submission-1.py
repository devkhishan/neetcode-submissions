class Solution:
    def maxArea(self, heights: List[int]) -> int:
        macs_ind = 0
        ans = 0
        i, j = 0, len(heights) - 1
        while i < j:
            dist = j - i
            ans = max(ans, dist * min(heights[i],heights[j]))
            if heights[i] > heights[j]:
                j -= 1
            else:
                i += 1
        return ans
      