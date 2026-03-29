class Solution {
    public boolean canJump(int[] nums) {
        // we have a variable that keep tracks of the index we want to reach
        int goal = nums.length - 1;

        // we iterate backwards
        for(int i = nums.length - 1; i > -1; i--){
            // we want to see if our jump can reach the goal
            // the jumps maximum value is the sum of the index and its value
            // if we can reach the goal, we can update it to the index we jumped from, index i
            if(i + nums[i] >= goal) goal = i;
        }

        // when we reach the end
        // we can reach true if if goal is 0 as that means from the start we can reach the end or surpass it
        return goal == 0;
    }
}

/*
We are given an integer array

We are asked to return a boolean

Description:

We are given an array of integers

Where each element in the array indicates the maximum jump length at this position

We want to return true if we can reach the last index starting from index 0

Example:

Input: nums = [1,2,0,1,0]

From index 0, we can take 1 jump to index 1

From index 1, we can take 2 jumps to index 3

From index 3, we can take 1 jump to the last index

Since we can reach the last index, we return true

An Approach:

We will try a greedy approach

Each element in the array tells us how far we can jump from that index

We start at the index 0

As we move through the array, we keep track of the farthest index we can reach

We check that if at any point, our current index is greater than the farthest index we can reach, we return false as we can't move forward

If we can reach or surpass the last index, we reach true

We initialize a variable to keep track of the farthest index we can reach

We iterate through the array

At each index we will check:

if our index is greater than our variable, as that means we can't reach this index and return false

and

update our variable to the greater value of itself and the current index plus its value

If we can complete the loop, we return true

Another Approach:

A decision tree is the brute force

We can also have a dp array where we iterate backwards

Where each element in the dp array, we mark true or false to show if we can reach it

We would then return dp[0]

Now we can use a greedy approach


We will iterate backwards

We will update the goal of what we want to reach

As if the previous index can reach the end or past, we now want to know if we can reach the previous index and that becomes the new goal

We then move onto the previous element of the previous and carry out the same logic

If we can reach from the starting index, we reach true
*/