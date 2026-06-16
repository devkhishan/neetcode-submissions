class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d = defaultdict(list)
        for i in strs:
            anag = [0] * 26
            for j in i: 
                anag[ord(j)-97] += 1
            hash = self.build_hash(anag)
           
            d[hash].append(i)
            
        return [d.get(i) for i in d]
    
    def build_hash(self, anag):
        hash = ""
        for i in range(26):
            if anag[i] != 0:
                hash += (chr(i+97) + str(anag[i]))
        return hash