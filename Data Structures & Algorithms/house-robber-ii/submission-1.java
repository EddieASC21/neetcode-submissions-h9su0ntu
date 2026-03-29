class Solution {
    public int rob(int[] nums) {
        // we skip the first house and include the last house
        int rob1 = helper(nums, 1, nums.length - 1);

        // we include the first house and skip the last house
        int rob2 = helper(nums, 0, nums.length - 2);

        // we then return the max of both subarrays
        int maxMoney = Math.max(rob1, rob2);
        
        // if we only had one house, we also want to take that into consideration for our maximum value
        return Math.max(maxMoney, nums[0]);
    }

    // helper function which is house robber 1 answer
    private int helper(int[] nums, int start, int end) {
        // p1 is nums[i - 2]
        // p2 is nums[i - 1]
        int p1 = 0, p2 = 0;

        for(int i = start; i <= end; i++){
            int temp = Math.max(nums[i] + p1, p2);
            p1 = p2;
            p2 = temp;
        }

        return p2;
    }
}

/*
We are given an array of integers

we are to return an integer

Description:

We are given an integer array named nums

nums[i] is the amount of money that the ith house has

The houses are in a circle

That would mean that the first and last house are neighbors

We cannot rob 2 adjacent houses

We want to return the maximum amount of money we can rob

Example:

Input: nums = [3,4,3]

The maximum amount of money is 4 as we can't take 3 and 3 as they are neighbors in this circle

An Approach:

The first and last house are neighbors, so we can't rob both

What we can do is

have to ways of robbing the neighbor and taking the maximum of both houses

We can rob from index 0 to the length of the array minus 2 where we exclude the last house

or

we can rob from index 1 to the length of the array minus 1 where we exclude the first house

We then return the maximum value from both cases

The plan:

Base cases:

if there is only one house, we return that value

if there is only 2 houses, we return the maximum value between both houses

We then use a helper function

Will use the same logic as house robber 1 and pass in the array, the start and end index

We then compute:

rob1 = helper(nums, 0, nums.length - 2)

and 

rob2 = helper(nums, 1, nums.length - 1)

Then return the maximum value between rob1 and rob2

Another Approach:

We use the house robber 1 algorithm as a helper function

where we take the maximum of two sub arrays with the help of the helper function

one where we exclude the last house and start from the first house

and 

one where we include the last house and start at the second house

we then get both of these values and return the greater one
*/