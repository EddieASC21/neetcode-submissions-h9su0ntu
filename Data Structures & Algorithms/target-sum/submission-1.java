class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // we will use a cache to store our sub problems
        // key is the index and current total and the value is the number of ways we reach the target
        Map<String, Integer> map = new HashMap<>();

        return helper(0, 0, nums, target, map);
    }

    // recursive helper function
    private int helper(int i, int curr, int[] nums, int target, Map<String, Integer> map){
        // base case

        // if we reach end of the array, we return 1 if curr is equal to the target value else we return 0
        if(i == nums.length) return curr == target ? 1 : 0;

        // we also check if this subproblem has been computed and stored in cache
        String key = i + "," + curr;
        if(map.containsKey(key)) return map.get(key);

        // recursive case

        // we either add the value at index i or subtract the value, we update the current sum and increment the 
        // we find the ways of choosing to add the value or subtract it to get the target value
        int ways = helper(i + 1, curr + nums[i], nums, target, map) + helper(i + 1, curr - nums[i], nums, target, map);
        // we store this as the value to our current key
        map.put(key, ways);

        return map.get(key);
    }
}

/*
We are given an integer and an array of integers

We are asked to return an integer

Description:

We are given an array of integers and given an integer that we will refer to as our target

For each number in the array, we can choose to either add or subtract it to the total

One example is that if our array is [1, 2], we can have the sum as -1 from +1 - 2

As if the array is [1, 1], then there are two different ways to sum the numbers in the array to 0

One is +1 - 1 = 0 and -1 + 1 = 0

We will return the different number of ways we can build the expression to equal to the target

Example:

Input: nums = [2,2,2], target = 2

We can take the first 2 as negative and take the rest as positive, that's one way

We can ensure that we have 2 positive 2's and 1 negative 2, as there are 3 spots, we would have 3 ways

The output is 3

An Approach:

At each index, we have 2 choices

We add the current number, + array[index]

or

We subtract the current number, - array[index]

We can recursively explore all combinations and count how many ways we can reach the target

We can use dfs and memoization

We will use a recursive helper function

Where the helper function will return the number of ways we can reach the target with the elements starting from the given index to the end given the current sum

Our base cases

if our index is equal to our array's length, we will check

if the current sum is equal to the target and if so we return 1

else we will return 0

Our recursive case:

We add the current number and recurse

we subtract the current number and recurse

We then add both results

Now memoization is keen

We will memoize the result by storing the index and the current sum so we will not do repeated work

Another Approach:

The order matters

We can use a decision tree

We will keep track of the index we are on

we will also keep track of our current sum to then check against the target

When our index go out of bounds, we have reached our base case

We will then check the current sum against the path

We can cache sub problems and store as the key the index and current sum at that index
*/