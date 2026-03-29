class Solution {
    public int singleNumber(int[] nums) {
        // we will have a variable where we store our XOR result 
        // we initialize it to 0 as number ^ 0 will always be number
        int res = 0;

        // we iterate through the array
        // we XOR all of the elements with the result
        for(int num : nums) res ^= num;

        return res;
    }
}

/*
We are given an array of integers

We are asked to return an integer

Description:

We are given an array of integers

We note that every ineteger appears twice except one

We want to return the integer that only appears once

Example:

Input: nums = [3,2,3]

We note that there are two numbers, 2 and 3

We notice that 3 appears twice while 2 appears once

So we return 2

An Approach:

We will use the bitwise XOR (^)

We notes the properties of XOR

a ^ a = 0 where any number XORed with itself becomes 0

a ^ 0 = a where any number XORed with 0 stays unchanged

So we note that a ^ b ^ c is equal to c ^ a ^ b

So we now note that if every number appears twice except for one, XORing all elements together will cancel out the numbers that appear twice and leave use with the unique one

Another Approach:

We will XOR all the input values and return the value at the end
*/