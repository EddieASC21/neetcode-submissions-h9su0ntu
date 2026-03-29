class Solution {
    public int[] countBits(int n) {
        // we have our array to store the number of 1s at each index
        int[] res = new int[n + 1];

        // we will keep track of the highest power of 2
        // this will determine how far back we must go for the previous problem
        int high = 1;

        // we iterate from 1 to n + 1
        for(int i = 1; i < n + 1; i++){
            // we check if we can update the highest power of 2
            if(high * 2 == i) high = i;

            // we now compute the number of 1s at this index via 1 + the previous answer index subtracted by the high
            res[i] = 1 + res[i - high];
        }

        return res;
    }
}

/*
We are given an integer

We want to return an array of integers

Description:

We are given an integer 

We count the number of 1's in binary representation of every number in the range from 0 to the integer

We want to return an array where at each index is the number of 1s in binary representation of the number

Example:

Input: n = 4

So the range is 0 to 4

So from 0, the binary representation is 0 and so we have 0 1s

At 1, the binary representation is 1, so we have 1 1

At 2, the binary representation is 10, so we have 1 1

At 3, the binary representation is 11, so we have 2 1s

At 4, the binary representation is 100, so we have 1 1

So we return an array with frequency of ones at each step which is [0, 1, 1, 2, 1]

An Approach:

We can use dynamic programming

We note that:

the number of 1s in i is the number of 1s in i >> 1 (i/2) + 1 if i is odd (last bit is 1)

So our reccurence relation is:

bits[i] = bits[i >> 1] + (i & 1)

As:

i >> 1 shifts the binary right by 1 (drops the last bit)

i & 1 is 1 if i is off (last bit it 1)

Another Approach:

We can note that going from 0 to 4 is a difference in the placement of 1 being introduced

then from there similar things can be said as we go up by 4s

So we wold be using the previous result to build up to this

So our base cases can be the number of 1s from 0 to 3

Then the reccurence relationship would be 1 + dp[n - 4]

We note that this isn't true when we reach 8 as would be 1 + dp[n - 8]

We note we update on significant bits which are numbers that are powers of 2
*/