class Solution {
    public int climbStairs(int n) {
        // we will have two variables
        int p1 = 1, p2 = 1;

        // we now iterate n - 1 times
        for(int i = 0; i < n - 1; i++){
            // we will update the variables

            // we use the help of a temp variable
            int temp = p1;

            // p1 will be set to the 2 previous values added
            p1 = p1 + p2;

            // we now shift p2 to the previous vale of p1
            p2 = temp;
        }

        return p1;
    }
}

/*
We are given an int and we must return an integer

Description:

We are given an integer representing the stair we want to reach

We can climb up the stairs with 1 or 2 steps at a time

we are to return the number of distinct ways to climb to the given integer

Example:

Input: n = 2

We can do 1 step and another 1 step so 1, 1 is a combination

We can do a 2 step and reach it so another combination, 2

so we return 2 distinct ways

An Approach:

We can climb with 1 step or 2 steps

So for us to reach step n, we could

Come to step n - 1 with taking 1 step 

or 

come to step n - 2 with taking 2 steps 

So we note the total number of ways of reaching step n is

ways(n) = ways(n - 1) + ways(n - 2)

Our base cases would be

ways(0) = 1 as only 1 way to stay still

ways(1) = 1 as only 1 way to get to 1 step

Another Approach:

We can use a decision tree and solve recursively

base case is if we reach n at a branch

As we will see 

we are repeating the problem and branching a lot of times

so we have recurring subproblems

We can use memoization to store subproblems that recurr multiple times

We will instead start at the base case and build up

We will store the array the results

so say n = 5

if we were to start at 5, the amount of ways to get to 5 is 1 (staying put)

if we want to go to 4, the amount of ways is 1, 1 step

So the array looks like [ , , , , 1, 1]

note that no matter n, the end of the array will always be [... , 1, 1]

now if we want to reach 5 from 3, it depends on the 2 subproblems after it

we can take 1 step from 3 to 4 and see that from 4, we already computed how many ways to get to 5

we take 1 step to 5

we then note that we take the next two subproblems from 3 and add it and place in the array

[ , , , 2, 1, 1]

we do the same for at 2

[ , , 3, 2, 1, 1]

from 1 we can do the same

[ , 5, 3, 2, 1, 1]

so then at the beginning we get

[8, 5, 3, 2, 1, 1]

with this our answer is the beginning of the array

note that we don't need an array

as the problem only relied on the two subproblems after it

so we will only keep track of those two variables

we then shift the variables values one place each until we get to the result of 0

will look like

[ , , , , 1, 1]
          ^  ^
          |  |
          one two

[ , , , 2, 1, 1]   
        ^  ^
        |  |
        one two 

[ , , 3, 2, 1, 1]   
      ^  ^
      |  |
     one two  

[ , 5, 3, 2, 1, 1]   
    ^  ^
    |  |
    one two   

[8, 5, 3, 2, 1, 1]   
 ^  ^
 |  |
 one two 

We return the one pointer as reached the beginning of the array     
*/