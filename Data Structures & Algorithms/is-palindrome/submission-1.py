class Solution:
    def isPalindrome(self, s: str) -> bool:
        k = [i.lower() for i in s if i.isalpha() or i.isdigit()]
        print(k)
        return k == k[::-1]