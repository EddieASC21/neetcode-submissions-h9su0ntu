class Solution {
    public int change(int amount, int[] coins) {
        // we create a cache to cache sub problems
        Map<String, Integer> map = new HashMap<>();

        return helper(0, 0, amount, coins, map);
    }

    // recursive helper function to carry out dfs on decision tree
    private int helper(int i, int curr, int amount, int[] coins, Map<String, Integer> map){
        // base case

        // we check if the current sum is equal to our target amount
        // if so we have found a valid combination
        if(curr == amount) return 1;

        // if we have surpassed our target then this not a valid combination and return 0
        if(curr > amount) return 0;

        // if we are out of bounds we return 0
        if(i == coins.length) return 0;

        // if we have already cached this subproblem we get and return it from the cache
        String subproblem = i + "," + curr;
        if(map.containsKey(subproblem)) return map.get(subproblem);

        // recursive case
        
        // we store in the cache the decision of taking this coin or not
        int val = helper(i, curr + coins[i], amount, coins, map) + helper(i + 1, curr, amount, coins, map);
        map.put(subproblem, val);

        return map.get(subproblem);
    }
}


/*
We are given an integer and an array of integers

We are asked to return an integer

Description:

We are given an array of integers which are used to represent coins

The coins are of different denominations 

We are also given an integer that represents our target amount

We want to return a number that represents the number of unique combinations to sum up to our target

If we cannot, then we will return 0

We can assume that we have an unlimited number of each coin 

We can also assume that each coin is unique

Example:

Input: amount = 4, coins = [1,2,3]

We can sum up to the target 4 in many ways

We can take 1 and continue to take 1 and notice after 4 1's we have summed up to 4

That would be one unique way

We can go back to 3 1's and try another coin and see that when we add any other coin we overshoot so this isn't a combination

We back track to 2 1's and we see we can add 2 to get 4 so that adds another combination

We have 2 unique ways

As with 2 1's we can't use any other coin, we back track to only 1 1 coin and so now we use different coins and see we over shoot with 2 and then 3

We also over shoot if take 2 2's with 1 coin already and so another solution is made as 1 1 coin and a 3 coin

That is 3 unique solutions

We backtrack to no one coins and do the same for the following index

At the end we are left with 4 unique solutions

We return 4

An Approach:

We will have a dp array

Where dp[i] will be the number of combinations to sum to i 

We will initialize dp[0] = 1 as there is 1 way to sum to 0 and that is choosing no coins

We will then iterate over each coin

We will iterate from the value if the coin until the amount

where we will add to dp[i] the value of dp[i - coin]

Thus building up from there

This will help deal with subproblems

We return dp[amount] at the end

Another Approach:

Brute force

We will use a decision tree

We have n decisions where n is the length of the array

We can choose each coin and update our sum

To avoid duplicates we cannot choose any previous indeces

The base case will be that we reached the amount

If we go over a total amount, we will stop

We will maintain an index for which coin we chose

When our index is at a coin, that means we can no longer choose a coin of a smaller index

We will cache repeated work

We will run dfs on our decision tree

We will pass in the parameters such as the index and current sum

We will cache repreated subproblems

We can also use a 2D grid

One dimension will be the amount, it will be indexed from 0 to the amount

The other dimension will be the coins, indexed by the coins in the array

The base case is if the amount of 0 

For the column that the amount is 0, we can say that there is 1 combination to get to 0 (we choose no coin)

So at every amount, depending the coin, we take the amount - coin and go to that cell and see the computed value

For the 2D array we will always look at the right and below
*/