class Solution {
    public int hammingWeight(int n) {
        int result = 0;
        
        // we loop while n is not 0
        while(n != 0){
            // we check if this place is 1 or 0 by modding by 2
            result += (n % 2 == 0) ? 0 : 1;
            // we then shift everything to the right by 1
            n >>>= 1;
        }

        return result;
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


*/