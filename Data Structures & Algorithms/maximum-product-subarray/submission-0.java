class Solution {
    public int maxProduct(int[] nums) {
        // we will set result as the first index
        int result = nums[0];

        // we will maintain the current minimum and maximum
        // we will set it as 1 as a neutral value
        int currMin = 1, currMax = 1;

        // we iterate over every number
        for(int i = 0; i < nums.length; i++){
            // we will have a temp variable to hold the current max before it is recomputed so that it can be encounted for in current minimum
            int temp = currMax;

            // we find our current max
            // we will take the current max as the new number visited multiplied by the current maximum
            // it can also be the new number visited multiplied by the current minimum
            // or it can also be the number itself
            currMax = Math.max(nums[i], Math.max(currMax * nums[i], currMin * nums[i]));
            // we do the same for the current minimum
            currMin = Math.min(nums[i], Math.min(temp * nums[i], currMin * nums[i]));

            // we will now update our result if the current max is greater
            result = Math.max(result, currMax);
        }

        return result;
    }
}

/*
We are given an array of integers and asked to return an integer

Description:

We are given an integer array

We want to find a subarray that has the largest product and return it

Example:

Input: nums = [1,2,-3,4]

The subarray with the largest product is 4

An Approach:

We will account for both positive and negative values

With negative values, the sign of our product can flip

A negative number can also make the minimum value into a maximum value

With this knowledge we will keep track of the maximum and minimum value at every index

So at every index we will track:

the current maximum product at the end of this index

the current minimum product at the end of this index

the global max which is the maximum value that we have seen so far

So we initialize the current maximum, current minimum, and global max as the first indece value

We will then iterate from index 1 to the end

We calculate the temporary values above that we are keeping track of

We will update our global max if our current max is greater

We then return the global max

Another Approach:

We need to maintain the maximum and minimum as you never know when the sign flips

Same approach 

Edge case

If we encounter a 0

Where if we find 0, we reset the minimum and maximum to 1 to ignore the 0
*/