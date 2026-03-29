class Solution {
    public int reverseBits(int n) {
        // we will have our result variable
        int result = 0;

        // we will iterate through every bit
        // we want to get the ith bit of this integer
        // we will shift the integer shuft all the way to the end
        // we will also and it with 1 to get the bit
        // we also would like to or it to add to our result 
        // where first we shift our bit by 31 minus the index
        for(int i = 0; i < 32; i++) result |= (((n >> i) & 1) << (31 - i));

        return result;
    }
}


/*
We are given an integer

We are asked to return an integer

Description:

We are given a 32-bit unsigned integer

We want to reverse the bits of the binary representation of the given integer

We want to then return the reverse value

An Approach:

What we will do is we will bit-by-bit reverse the number

We will have a variable that will hold our result and which is what we will return at the end 

We will loop 32 times as we are given a 32 bit integer

We will shift our result left by 1 bit to make room

We will extract the last bit of the given integer such as n & 1 and we will add this to our result

We will then shift the integer right by one bit such as n >>= 1

Then we will return the result 

This ensures that the least significant bit of n becomes the most significant bit in our result and so on

Another Approach:

We can do logic and to see if the bit is a 1 or 0

After we and, we shift to the left our result

Now what we want to instead of logic and is to do logic or
*/