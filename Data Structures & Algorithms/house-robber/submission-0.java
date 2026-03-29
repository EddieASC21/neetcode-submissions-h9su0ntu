class Solution {
    public int rob(int[] nums) {
        // we will maintain the last two maxes
        // we initialize them as 0 as we can have empty array
        int p1 = 0, p2 = 0;

        for(int i = 0; i < nums.length; i++){
            // we want to compute how much we can rob up till i
            // p2 is the last house we robbed
            // p1 is the house we robbed before p2
            // nums[i] + p1 is robbing the previous previous house and the current house
            // p2 is robbing the previous house
            // array looks like [p1, p2, n, n + 1, ...]
            int temp = Math.max(nums[i] + p1, p2);
            // we update p1 to p2
            p1 = p2;
            // we update p2 to the new current max
            p2 = temp;
        }

        // p2 will be equal to the last value
        return p2;
    }
}

/*
We are given an array of integers

we must return an integer

Description:

We have an integer array where the array[i] is the amount of money the ith house has

The houses are in a straight line

the ith house is neighbors to the ith - 1 house and ith + 1 house

We want to rob the money from the houses yet cannot rob two houses next to each other

We want to return the max amount of money we can rob

Example:

Input: nums = [2,9,8,3,6]

We can either steal nums[0] + nums[2]  + nums[4] or nums[1] + nums[3] which is 16 or 12 and the answer is 16

An approach:

We can either:

rob the current house and skip the previous

skip the current house and keep the max loot up to the previous house

We want to maximize the total amount of money without robbing two adjacent houses

The reccurrence relation:

We let dp[i] be the maximum amount of money that can be robbed from the first i + 1 houses

So then we have:

dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])

Where

dp[i - 1] means we skip the current house 

dp[i - 2] + nums[i] means we rob the current house

The base cases:

if nums.length == 0 then we return 0

if nums.length == 1 then we return nums[0]

Then we can set

dp[0] = nums[0]

dp[1] = Math.max(nums[0], nums[1])

Another Approach:

We can use a decision tree for brute force

where we choose to rob the current house or skip to the next one

The relationship is we have two choices

rob the first house and the rest of the array after the next house

or skip the first house and rob the rest of the array

rob = max(arr[0] + rob[2:n], rob[1:n])

We will solve the subproblems

Base cases:

We can decide to rob the first house

if we want to we can decide to rob the second house and skip the first one

when we get to house 3, we can rob house 3 and 1 or just rob house 2 comparing the max values robbed

when we get to house 4, we can rob house 2 and 4 or house 1 and 3, we would take the max of the values

We can compute the new max value by looking at the previous two values 

as we can decide to rob the current and the remainder after its neighbor or skip the current and rob the remainder
*/