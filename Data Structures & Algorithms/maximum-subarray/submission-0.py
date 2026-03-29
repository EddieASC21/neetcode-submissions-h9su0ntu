class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        out = float('-inf') 

        curr = 0

        for i in range(len(nums)):
            if curr < 0:
                curr = 0
            curr += nums[i]
            out = max(out, curr)

        return out
        