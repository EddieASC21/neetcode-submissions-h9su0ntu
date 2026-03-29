class Solution {
    public int missingNumber(int[] nums) {
        int result = nums.length;

        // we will iterate through the array with adding the indices of 0 to n and subtracting from it the values in the array
        for(int i = 0; i < nums.length; i++) result += (i - nums[i]);

        return result;
    }
}

/*
We are given an array of integers

We are to return an integer

Description:

We are given an array of integers that range from 0 to the length of the array

There are no duplicates in the array 

We want to return the single number in the range that is missing from the array

Example:

Input: nums = [1,2,3]

As the numbers are from range of 0 to the length of the array which is 3

We see that 0 is missing in the array

We return 0

An Approach:

We can use Gauss' Formula

The idea would be we find the expected sum of 0 to n which can be calculated as n * (n + 1)/ 2

Then we will subtract the actual sum of the array from the expected sum and that will return the missing value

Another Approach:

We can use XOR

We will XOR every number from 0 to n with every number in the array 

The final value will be the missing value that we will return 

Additional Approach:

We can use XOR

As if we take an array with all values of 0 to n and the given array

If we XOR those two array, we are left with the missing value

One More Approach:

We can take the sum of the array of 0 to n 

We then take the sum of the array given to us

Subtract those sums and we are left with the missing values
*/