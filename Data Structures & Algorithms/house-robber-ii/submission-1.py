class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
     
        def helper(nums): 
            a, b = 0, 0
            for i in range(len(nums)):
                a, b = b, max(nums[i] + a, b)
            return b
        
        return max(helper(nums[1:]), helper(nums[:-1]))
        