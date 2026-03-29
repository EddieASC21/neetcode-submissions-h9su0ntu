class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // we want to add a 0 to the end of the array to help with computations
        // must do this as int[] is fixed sized
        int[] c = Arrays.copyOf(cost, cost.length + 1);
        c[c.length - 1] = 0;

        // iterate the array in reverse order
        // we want to take the min between taking 1 or 2 jumps
        for(int i = c.length - 3; i >= 0; i--) c[i] += Math.min(c[i + 1], c[i + 2]);
        
        // so now we return is the minimum of the first two indeces
        return Math.min(c[0], c[1]);
    }
}

/*
We are to return an int

We are given an integer array

Description:

We are given an array of integers that represent cost

We denote cost[i] as the cost of taking a step from the ith floor

After paying the cost, we can either take the i + 1 step or the i + 2 step

We can start from the 0th or 1st floor

we will return the minimum cost to reach the top of the stair case in this case past it

Example:

Input: cost = [1,2,3]

We can start at cost[0] or cost [1]

if we start at cost[1] and take 2 steps with the cost, we are out of bounds with cost of 2

at cost[0] we can take 2 steps to cost[2] with cost of 1 and then take 1 or two steps and take the price total cost of 4

or we can take cost[0] and take 1 step with price 1 and take 2 steps from cost[1] and pay price 3

we note though we can get to index 1 for free so minimum cost is 2

An approach:

So to reach step i 

We can try

step(i - 1) and pay the cost of cost[i - 1]

or 

step(i - 2) and pay the cost of cost[i - 2]

We can then build from the bottom up with storing the minimum cost to reach each step

We can define a dp array

we set dp[i] as the min cost to reach step i

We can reach step n which is the last index and in array is dp[cost.length]

Our base cases would be 

dp[0] = 0 where we can start at step 0 without paying 

dp[1] = 0 where we can start at step 1 without paying 

Our recurrence relation is:

dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])

our final answer as said would be dp[cost.length]

Another Approach:

we always have two decisions

make one jump or two jumps

we can use a decision tree

We can also use memoization to store sub problems that recur

We will use a dp array

We will use the input array and use two variables

to know the minimum cost from index 0

we must know the minimum cost from index 1 and 2

to know the minimum cost from index 1

we must know the minimum cost from index 2 and 3

so we will solve the subproblem from right to left 

we will solve the subproblem to solve the original problem

the cost to get from index 2 to 3 or 4 is just 20

now at index 1 we can get to index 3 with 15 or to index 2 that has a value of 20, so at cost[1] we have 15 or 15 + 20

we note we take the min so we take 15

We add a place holder at index 3 as 0

so then at index 0, we can take one jump which lands at 15 or take 2 jumps which leads to index 2 with value 20

so at index 0 we have minimum of 10 + 15 and 10 + 20 which is 25 

now in the array each index shows the cost to get to the top

since we only can start at index 0 or 1, we take the minimum of the values at these indeces
*/