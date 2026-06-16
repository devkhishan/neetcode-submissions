class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        s = set()
        u = []
        res = 0
        for i in nums:
            if i not in s:
                s.add(i)
                u.append(i)
        
        for i in u:
            count = 1
            k = i
            while (k+1) in s:
                count += 1
                k+=1
            res = max(res, count)
        return res