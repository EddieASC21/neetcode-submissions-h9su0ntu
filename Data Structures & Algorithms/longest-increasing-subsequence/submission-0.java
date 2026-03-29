class Solution {
    public int lengthOfLIS(int[] nums) {
        // array hold every LIS at each index
        int[] dp = new int[nums.length];

        // we initialize every value to 1 as a number is a subsequence of length 1 by itself
        Arrays.fill(dp, 1);

        // we will iterate through the array in reverse order
        for(int i = nums.length - 1; i >= 0; i--){
            // we will start at index i and we will iterate over every subsequence that came after it until the end of the array
            for(int j = i + 1; j < nums.length; j++){
                // before we update LIS, we check if the previous index value is less than the following one as this is an increasing subsequence
                // if possible, we increase the LIS at that index as either itself or the following index + 1
                if(nums[i] < nums[j]) dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }

        // we will find the LIS by going through our finalized array and returning the max value
        int result = 0;

        for (int lis : dp) result = Math.max(result, lis);

        return result;
    }
}

/*
We are given an array of integers 

We are asked to return an integer

Description:

We are given an integer array where we want to return the length of the longest increasing subsequence

A subsequence is a sequence that we can derive from the given sequence

We can remove some elements or not but cannot change the order these elements appear

Such as cat can be derived from crabt as we can remove r and b to create the sequence cat

An example:

Input: nums = [9,1,4,2,3,3,7]

The answer is [1, 2, 3, 7]

Where if we started at 9 there is no valid sequence as no number is greater than 9 so the longest length is 1

If we start at 1, we see that as we continue that 4 is greater and so we start that sequence at 4 and build up

so then we have from 4 that 7 is next greater value and so that is the last index of the array and so the greatest length is 3

We also go back to 1 and see that there are other values that are greater than it such as 2

We start at 2 and then we see 3 and 7 is greater and so the greatest length is 4

So then so on we move onto 3 from 1 and so from 3 we go to 7 and the length is 3

We then move on from 1 to 7 as the next possible sequence and the length is 2

As we continue, we realize the greatest length found is 4

An Approach:

We can have an array 

Where array[index] is the length of the longest increasing subsequence at that index

So to begin

We initialize an array with a length of the array of integers given and set all the indeces as 1

As every number by itself is a subsequence of length of 1

So from every index starting at 1 until the end of the array

We check all of the previous values before this index and see if it is less than

So if that value is less than the index, then we can increase the longest increasing subsequence length ending at that value

Then we would take the maximum value for the length as the value in our array at that index or the newly value plus 1

We would then return the maximum value in our array

A "better" Approach:

We can use binary search with the addition of patience sort

We will maintain an array

Where array[index] is the smallest tail of all possible increasing subsequence that is the length of index plus 1

We can replace the elements in the array using binary search to keep it sorted

We will create our array

Where for each number in our given array 

We will use binary search to find our intersection 

If it is bigger than all elements we will append to our array

Else we will replace the element at that index

One More Approach:

Brute would be using dfs

We will generate every possible sequence

We have a choice if we will include a value in our subsequence

We will use a decision tree and run dfs on it

We can also subproblems in a cache

Our decision tree would start off with which index to start out at 

Then we will continue with deciding which valid indeces to include

We also see similar branches as we continue the entire tree hence why we cache the subproblems

We will store the longest increasing subsequence as the value and the index as the key

With then have a complete cache, we return the greatest value stored in our cache

We can also start at the last index and work our way backward

Our base case

Since no value can come after the last index, we note the LIS as 1 for this index

So to find the LIS at the previous index, we take the greatest value which is either 1 (itself) or 1 plus the LIS found in the next index if and only if the value at the previous index is less than the one at the next index
*/