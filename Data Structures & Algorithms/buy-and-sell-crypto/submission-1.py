class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        res = 0
        macs = -1

        for i in range(n-1, -1, -1):
            macs = max(prices[i], macs)
            res = max(res, macs - prices[i])
        
        return res
