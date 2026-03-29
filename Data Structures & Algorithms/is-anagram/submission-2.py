class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        def helper(f: str, lis: List[int]) -> List[int]:
            for i in range(len(f)):
                lis[ord(f[i]) - ord('a')] += 1
            return lis

        return helper(s, [0] * 26) == helper(t, [0] * 26)
            
        