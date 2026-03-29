class Solution {
    public int jump(int[] nums) {
        // we track the number of jumps needed
        // we also need pointers to tell us our range/level
        // we keep track of the farthest jump we can make
        int jumps = 0, left = 0, right = 0, farthest = 0;

        // we iterate until our right pointer reaches the last index
        while(right < nums.length - 1){
            // we will iterate through our range
            // we update the farthest we can jump
            for(int i = left; i < right + 1; i++) farthest = Math.max(farthest, i + nums[i]);
            
            // we now update our window/level/range
            // increment jumps made when moving to next level
            left = right + 1;
            right = farthest;
            jumps++;
        }

        return jumps;
    }
}


/*
We are given an array of integers

We are asked to return an integer

Description:

We are given an array of integers

Where each element at each index represents the maximum length of a jump we can make from that index

So for example, if we are at nums[i], we can jump to any index i + j where:

j is less than or equal to the element at this index

and

where i + j is less than the length of the array ensuring that it is in bounds

We start at the 0th index

We want to return the minimum number of jumps to reach the last position in the array

We are safe to assume that there is always a valid answer

Example:

Input: nums = [2,4,1,1,1,1]

We start at the first index

where the element is 2

So we can take 1 step or 2 steps

We take 1 step as we see the value is 4 at the next element

from then we can take 4 steps and reach the end of the array

As we have reached the end of the array, we return 2 as thats as many steps we took

An Approach:

We will try a greedy approach

Where we will do a forward scan with the help of range tracking

We will keep track of:

a variable that keeps track of the farthest index we can reach from our current index

a variable that keeps track of what element we reach in our range

a variable that keeps track of the number of jumps we made, we will return this variable

We will initialize each variable to 0

We will iterate from the start of the array to the second last index as we don't need to jump from the last index

At each index, we update our variable to keep track of the farthest index we can reach

if we reach the end of the current range, we must make a jump

we increment our variable that keep tracks the number of jumps we made

we update our variable that keep tracks of the end of the current range to the farthest we can reach to extend the range

At the end, we return the number of jumps we made

Another Approach:

Imagine bfs where we travel by levels/ranges
*/