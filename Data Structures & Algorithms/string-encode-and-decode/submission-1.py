class Solution:

    def encode(self, strs: List[str]) -> str:
        result = ""
        for i in strs:
            result += str(len(i)) + "," + i
        return result

    def decode(self, s: str) -> List[str]:
        result = []
        i = 0
        while i < len(s):
            num = ""
            while s[i]!=',':
                num += s[i]
                i+=1
            l = int(num)
            result.append(s[i+1:i+1+l])
            i+=l+1
        return result
