class Solution {
    public int maxSubArray(int[] nums) {
        // we keep track of our current sum and maximum sum
        // we set both of these to the first index
        int curr = nums[0], result = nums[0];

        // we will iterate through every element
        for(int i = 1; i < nums.length; i++){
            // we decide to continue the current subarray or restart a new one
            curr = Math.max(nums[i] + curr, nums[i]);
            // we update our maximum value seen if the current sum is greater
            result = Math.max(result, curr);
        }

        return result;
    }
}

/*
We are given an array of integers

We are asked to return an integer

Description:

We are given an array of integers

we want to find the subarray with the largest sum 

We want to return the greatest sum

A subarray is a contiguous non-empty sequence of elements within an array

Example:

Input: nums = [2,-3,4,-2,2,1,-1,4]

The answer is 8

We would take the subarray from 4 to 4, [4,-2,2,1,-1,4]

An Approach:

We will use kadane's algorithm

So

At each index, we have two choices

Extend the previous subarray

start a new subarray at the current element

We can choose which ever one provides the greater sum at that index

So

We initialize two variables

max sum which will track the maximum sum found so far

curr sum which will track the current subarray sum found up until this index

We will iterate through the array

We will set curr sum as the maximum between the current element and the current element plus the current sum

This will decide if we start a new subarray at this element or continue the previous one

We will set max sum as the maximum between the current max sum and curr sum

We update max sum if the current subarray sum is greater

At the end we return max sum

Another Approach:

Brute force is to find all subarrays and compute all their sums

Then return the greatest sum of any subarray

Instead we iterate through the array

We keep track of the current sum 

If it ever reaches a negative current sum, we reset the current sum

We also keep track of the maximum sum seen to return later
*/