class Solution {
    public int hammingWeight(int n) {
        int res = 0;

        // we loop while n is not 0
        while(n != 0){
            // we set n to be itself AND with itself - 1
            n &= (n - 1);
            // we increment the result each time
            res++;
        }

        return res;
    }
}


/*
We are given an integer

We are asked to return an integer

Description:

We are given an unsigned integer

We want to return the number of 1 bits in its binary representation

We may assume that this number is positive and fits within 32 bits

Example:

Input: n = 00000000000000000000000000010111

We return 1 as there are 4 1s

An Approach:

We can isolate the least significant bit (lsb) using n & 1

We can right-shift the number using n >>>= 1 (logical shift for unsigned) to check each bit

We can also remove the lowest set bit using n &= (n - 1), this is faster when n has only a few 1s

Another Approach:

What we can do is with the current n value, we either mod it by 2 or do logical AND 

This would return the value of the last bit at the end

After that we would then shift the bit by 1 then updating the value at the end

To improve the runtime we can try this:

We will take n and set it equal to n logic AND it with n - 1

Each time we do that, we increment our result
*/