class Solution {
    public int maxCoins(int[] nums) {
        // we will modify the array by adding a 1 to both ends
        int[] updated = new int[nums.length + 2];
        
        updated[0] = 1; 
        updated[nums.length + 1] = 1;

        for(int i = 0; i < nums.length; i++) updated[i + 1] = nums[i];

        Map<String, Integer> map = new HashMap<>();

        return helper(updated, 1, nums.length, map);
    }

    // recursive helper method
    private int helper(int[] updated, int left, int right, Map<String, Integer> map){
        // base case

        // if our left and right pointer point to the same index
        // we have one balloon left to pop
        // so if our left pointer is greater than the right, we have ran out of balloons
        if(left > right) return 0;

        // we check if we have computed this subproblem
        String key = left + "," + right;
        if(map.containsKey(key)) return map.get(key);

        // recursive case
        
        int maxCoins = 0;

        // we will consider every index as the last balloon popped in the interval
        for(int i = left; i <= right; i++){
            // this is the last index considering so we multipy it by the bounds
            int coins = updated[left - 1] * updated[i] * updated[right + 1];
            // we also add the coins we would get from the left and right sub arrays
            coins += helper(updated, left, i - 1, map) + helper(updated, i + 1, right, map);
            // we take the greater value
            maxCoins = Math.max(maxCoins, coins);
        }

        map.put(key, maxCoins);
        
        return maxCoins;
    }
}

/*
We are given an array of integers

We are asked to return an integer

Description:

We are given an array of integers that is the size of n

The ith element is a ballon with the value nums[i]

We want to burst all balloons

If we burst the ith ballon, we will get nums[i - 1] x nums[i] x nums[i + 1] coins

If i - 1 or i + 1 results in the index going out of bounds, we will set the value of nums[i - 1] and/or nums[i + 1] be 1

We want to return the maximum number of coins we can receive by bursting all balloons

Example:

Input: nums = [4,2,3,7]

What we can do is burst the second ballon, 2

So that means that the coins we get is 4 x 2 x 3 is 24

We then have the array [4, 3, 7]

We can then burst the (new) second balloon, 3

So that means we gain 4 x 3 x 7, 84, coins 

We now have the array as [4, 7]

We burst the first ballon, 4

So that means we gain 1 x 4 x 7, 28, coins

Now the array is [7]

So we gain 1 x 7 x 1, 7, coins

So from bursting all ballons as the array is now [], we have 24 + 84 + 28 + 7 coins

The answer is 143 coins

An Approach:

We will keep track of what balloon to burst last in an interval instead of what balloon to burst next

We can use a 2D dp table

Where dp[i][j] being the maximum number of coins we can get from bursting balloons between the indeces i and j (exclusive)

We will add a 1 at the beginning and end of the array

This will help with where nums[i - 1] and/or nums[i + 1] be considered out of bounds

We will try every balloon k between i and j as the last balloon to burst in the interval

Reccurence Relationship:

dp[i][j] = max(dp[i][j], dp[i][k] + dp[k][j] + nums[i] x nums[k] x nums[j])

Where;

dp[i][k] is the maximum amount of coins we can gain from bursting balloons from i to k

dp[k][j] is the maximum amount of coins we can gain from bursting balloons from k to j

nums[i] x nums[k] x nums[j] is the coins we gain from bursting k last when i and j are only left in the interval

Base Case

if j - i is less than or equal to 1, then dp[i][j] is 0 as it is an empty interval/array as there are no balloons to burst in between i and j

The answer will be stored in dp[0][n = nums.length + 1] 

Another Approach:

We modify the input array by ending a 1 at each end
*/