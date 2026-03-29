class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;

        for(int num : nums) total += num;

        if(total % 2 != 0) return false;

        int target = total / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = target; i >= num; i--) dp[i] = dp[i] || dp[i - num];
        }

        return dp[target];
    }
}

/*
We are given an array of integers and asked to return a boolean

Description:

We are given an array of positive integers

We are asked to return if it is possible to partition the array into two subsets

Where these 2 subsets have the same sum given the numbers in it

Example: 

Input: nums = [1,2,3,4]


We can partition to this array into two subsets

One subset having [1, 4] and the second having [2, 3]

Where both of these subsets have a sum of 5

So we can return true

An Approach;

We note that if the sum of all elements is odd, we cannot divide it equally

If the sum of all elements is even, we must find if a subset exists where the sum is the target equal to total sum divided by 2

We will treat this as a 0/1 Knapsack problem

So what we will do is:

Find the total sum of the array

If the total is odd, we will return false

We let our target amount for each subset to be total sum divided by 2

We just need to find if one subset with the sum of the target exists

So

We will have an array

Where array[index] is true if a subset sum of index is possible else we will set as false

We will go through all numbers in the array

We will iterate from the target down to the number

Our base case:

We will set array[0] as true as the sum of 0 is always possible

Another Approach:

We will have a target variable which is half of the total sum of the array

We will visit every number in the array

We chan choose to include that number to add up to the target or not

We can see if the numbers we ever choose to include to the subset will add up to our target

Brute force is to have a decision tree

We include the number to our sum or we don't and we continue

Base cases would be if we ever meet the target in one branch where we can return true or if we went over the target

We note that the sub problem is that when we choose a number to include in our subset, the target now becomes target minus number we chose

Now after choosing an element, our index points to the next element and we are no longer dealing with the entire array rather a sub array

We can then cache these sub problems to reduce repeated work

After we make a decision, we update our index and target which are the two variables of our cache

So we can run a dfs solution with a cache

Yet we can improve the memory complexity

We would start at the first value

For every sum in the sub array that is possible if it equal to the target we can return true

Or for every sum in the sub array added with the new index we choose if equal to the target we can return true

We will work backwards

We will check how many possible sums we can make at the index

Where we can make the sum array[index] or 0

We will store these values in a set

We will iterate through the values in the set that were just added and add the next index to it

We will check if the sum ever has our target and return true if found
*/