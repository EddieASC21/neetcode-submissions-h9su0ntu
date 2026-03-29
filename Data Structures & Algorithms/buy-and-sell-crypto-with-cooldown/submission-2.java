class Solution {
    public int maxProfit(int[] prices) {
        // help keep track if we buying or selling
        // if we buy our index is i + 1
        // if we sell then its i + 2 to allow a cool day

        // we will cache subproblems
        // the key is the index and a boolean displaying if we are buying
        // the value is the maximum profit
        Map<String, Integer> map = new HashMap<>();

        // we call our helper function 
        // at index 0, the buying state will always be true
        return helper(0, true, prices, map);
    }

    // recursive helper function to run dfs
    private int helper(int i, boolean buying, int[] prices, Map<String, Integer> map){
        // base cases
        
        // we check if we go out of bounds
        if(i >= prices.length) return 0;

        // we check if this subproblem has been cached and if so we return that
        String key = i + "-" + buying;
        if(map.containsKey(key)) return map.get(key);

        int result = 0;

        // recursive case

        // decisions we can make where it is dependent on if we are buying or selling
        if(buying){
            // if we are buying, we have two choices
            // we can buy or cooldown

            // if we buy, we call dfs and update the index
            // if we buy our profit is decreased by what we just bought
            int buy = helper(i + 1, false, prices, map) - prices[i];
            // with cool down we don't do anything 
            int coolDown = helper(i + 1, true, prices, map);
            
            // we will cache our result
            // we will set the value for the key as the maximum value of buy and cool down
            result = Math.max(buy, coolDown);
        }
        else{
            // if we are selling we have to update index by 2 as we must take a cool down day and update the boolean
            // we now sell so we add the price at the index
            int sell = helper(i + 2, true, prices, map) + prices[i];
            // we can as well take a cooldown
            int coolDown = helper(i + 1, false, prices, map);
            // we will now cache 
            result = Math.max(sell, coolDown);
        }

        // we add to cache and return the max profit
        map.put(key, result);
        return result;
    }
}

/*
We are given an array of integers

We are asked to return an integer

Description:

We are given an array of integers 

Where array[index] is the price of NeetCoin on the ith day

We can buy and sell one neetcoin multiple times

To do that we must follow these rules:

After we sell a coin, we cannot buy another one until the next day allowing for a cool down period of 1 day

We can only have at most one coin per day

We can make as many transactions as we want

At the end we return the maximum profit that we achieved

Example;

Input: prices = [1,3,4,0,4]

We can buy on day 0 that has a price of 1 and sell on day 1 at a price of 3

So then we have a profit of 2

We wait to buy untill day 3 where the price is 0 and sell on day 4 at price of 4

Making us a profit of 4

So now our max profit is 2 + 4 which is 6

Description:

We can buy or sell, but after selling, we must cool down for 1 day

We can only hold 1 coin at a time

So what we can do

We can track 3 states per each day/index

the 3 states are:

hold[index] which is the max profit ending at this index if we don't sell and hold the stock

sold[index] which is the max profit ending at this index if we decide to sell the coin now

rest[i] which is the max profit ending at this index if we do nothing

So now to compute these states at each day/index

for hold[index] it would be the max value of holding[index - 1] or rest[index - 1] - prices[i]

This means we either keep holding or buy today as long as long as we rested yesterday

then sold[index] is hold[index - 1] - prices[i] 

This means we can sell if we were holding yesterday

also rest[index] is the maximum of rest[index - 1] or sold[index - 1]

As resting means that we just rested yesterday or just completed the cooldown

So we would intialize for day 0

hold[0] would be -prices[index] as we buy first day

sold[0] being 0 as we can't sell first day

rest[0] being 0 as we do nothing

We then return the maximum of sold[last index] or rest[last index] this as if we want to maximize profit we can't hold onto stock

Another Approach:

At each index 

we can buy or sell

Yet we can only sell if we have bought a stock

So at index 0 we always buy as we don't own stock

We must always keep track if we are buying or selling

Well other than buying at first, we can do a cool down

After buying we can't buy again, we can either cooldown or sell

When we buy we do a negative operation

When we sell we do a positive operation

if we cool down, we keep profit the same

After selling we can't buy or sell so we have to choose cooldown

after cooldown we can only buy or cooldown

we can run dfs on decision tree to find maximum profit

We can also cache subproblems

The key of the cache will be the index and a boolean if we are buying or selling
*/