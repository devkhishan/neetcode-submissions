class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        n = len(s)
        if n <= 1: return n
        hmap = {}
        res = 0
        l, r = 0, 1
        hmap[s[l]] = 0
        while l<r and r<n:
            if s[r] in hmap:
                l = max(l,hmap[s[r]]+1)
            hmap[s[r]] = r
            res = max(res, r-l+1)
            r += 1
        return res