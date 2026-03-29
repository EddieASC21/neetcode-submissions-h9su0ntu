class Solution {
    public int change(int amount, int[] coins) {
        // we will use a 2d grid 
        int[][] dp = new int[amount + 1][coins.length + 1];

        // we will set the last column as all 1's due to the fact that we can only get to the amount 0 if we choose no coins
        for(int i = 0; i <= coins.length; i++) dp[0][i] = 1;

        // so we will now iterate over every cell
        // we will iterate from the amounts
        for(int i = 1; i <= amount; i++){
            // we will now iterate over every coin 
            for(int j = coins.length - 1; j >= 0; j--){
                // we skip the coin
                dp[i][j] = dp[i][j + 1];
                // if we use the coin, we check if we can include it
                if(i - coins[j] >= 0) dp[i][j] += dp[i - coins[j]][j];
            }
        }

        return dp[amount][0];
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