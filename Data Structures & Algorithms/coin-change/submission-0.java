class Solution {
    public int coinChange(int[] coins, int amount) {
        // we will have a dp array to store all the minimum amount of coin needs for each subproblem
        int[] dp = new int[amount + 1];

        // we populate the array with a max place holder value
        Arrays.fill(dp, amount + 1);

        // base case 

        // the minimum amount of coins to get the value 0 is 0
        dp[0] = 0;

        // we compute for every value in dp
        // we will iterate from 1 to the final amount
        for(int i = 1; i < amount + 1; i++){
            // we will try every coin as a possibility
            for(int coin : coins){
                // we will take the coin and subtract it from the amount/index we are at long as greater than 0
                // this can be a possible solution and so we check it against the minimum value found to possibily update the minimum value
                if(i - coin >= 0) dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        // we check if the amount was computed/not the place holder value, and if it is we return -1
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}

/*
We are given an array of integers and an integer

we are to return an integer

Description:

We are given an integer array where each index is a different value in terms of of money

We are also given an integer which represents our target

We want to return the minimum amount of coins (what are indeces represent) to reach the target

If that is not possible, we will return -1

We can use each coin as many times as we want

Example:

Input: coins = [1,5,10], amount = 12

We can build up to 12

We can choose 1 12 times so our min is 12 right now

we can choose 2 fives and 2 ones and get 4 as new minimum

we can do 7 ones and ond 5 which is 8 but not new minimum

we can do one 10 and 2 ones with is 3 and the new minimum and the output

An Approach:

We will have a dp array

With dp[i] being the minimum number of coins to achieve the amount i

We want to compute dp[amount]

We will initialize dp[0] = 0 as we need 0 zero coins to build up to 0

We also will initialize the rest of the array with impossible large values to build up to 

Then from every amount/index from 1 to amount, we will try every coin

If we are able to use this coin then we check against using this coin on top of whatever was needed to make i - coin to get the minimum value

at the end we check if the finally index in our dp array is equal to the amount

Another Approach:

We can use a decision tree and use dfs

Where every time we have the decision of choosing the coin or not but its the amount of coins/length of the array not 2 decisions

Where now the base case is every time we take a coin we subtract it from the amount and if we reach 0, this a valid path

Another base case is that if the amount ever reaches a negative value then it is not a valid path

then we want to return the minimum path length

Now what we see when we create our decision tree is repeated sub problems that we can cache

That is Top-Down memoization

Yet we can solve this by bottom up

where we start at the subproblems and build up

where the minimum amount of coins to reach 0 is 0 

then we can look at the minimum number of coins to sum to 1 and we see that it is in array and so we can write minimum amount to reach 1 is 1

then we can repeat the process

we see the minimum number of coins to get to 2 and so we take a 1 as the rest of the coins in the array overshoot, so now the new subproblem is what is the minimum amount to get 1 which we have found as 1

As we see that dp[2] is dp[1] + 1 which is 1 + 1

We will repeat this process from amount 0 to the amount given

To find the dp[amount] we will choose every coin and continue the sub problem and return the minimum amount found
*/