class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        zc = nums.count(0)

        if zc == 1:
            zi = nums.index(0)
            res = [0] * len(nums)
            res[zi] = 1
            for i in nums:
                if i != 0:
                    res[zi] *= i
            return res
        elif zc > 1:
            return [0] * len(nums)
        else:
            val = math.prod(nums)
            return [val//i for i in nums]
