class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        return [k for k,_ in sorted([(k1,v1) for k1,v1 in {x:nums.count(x) for x in set(nums)}.items()], key=lambda x : -x[1])[:k] ]