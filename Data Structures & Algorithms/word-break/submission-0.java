class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // we will have a dp array where dp[i] represents if that index is true if a word of a length equivalent to the index can be segmented to it
        boolean[] dp = new boolean[s.length() + 1];

        // base case
        
        // if we reach the last index, that means we can segmate the word, and so we return true
        dp[s.length()] = true;

        // we iterate over every index of the string in reverse order
        for(int i = s.length() - 1; i >= 0; i--){
            // we will try every word in our word dictionary
            for(String word : wordDict){
                // we will check if the word we are checking against will not go out of bounds given our index
                // we also want to check if this substring is equal to the word we chose
                // we will then set dp[i] to be the index plus the length of our word which will call recursively and if possible reach our base case and return true
                if(i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)) dp[i] = dp[i + word.length()];

                // now if we have found an index that returns true, no need to continue as we are not trying to find number of ways
                if(dp[i]) break;
            }
        }

        // we will return dp index 0 as that will return true if we are able to reach our base case
        return dp[0];
    }
}

/*
We are given a string and a list of strings

we are asked to return a boolean

Description:

We are given a string with a dictionary of strings given as a list

We want to return true if the string can be segmented from the words from the dictionary given

We are allowed to reuse the words in the dictionary as many times as i want

We can assume all words in the dictionary are unique

Example:

Input: s = "applepenapple", wordDict = ["apple","pen","ape"]

The output is true

As with apple amd pen and apple from the list being used to create the string

An Approach:

We want to know if the string can be broken into words found in the dictionary of words given

So at every index in the string, we check if there is a substring up until that index that exists in our dictionary and can be built off previous valid segments

Plan:

We convert our word dictionary that is given as a list to a set to provide O(1) look up time

We create a dp array that is the size of the string's length + 1

where dp[i] signifies if the string[0...i - 1] can be segmented

Base Case:

dp[0] is set to 0 as any empty string can be segmented

We will iterate from index i which is set to 1 to the length of the string

where for each index j from 0 to i

we check if dp[j] is true and the substring from j to i is in the dictionary via O(1) look up from the set, we can set dp[i] to be true

We will return dp[length of string]

Another Approach:

We will have a decision tree

We start at the first index, 0

where the subproblem is if a valid substring is found, we move the index to index + 1

Our decisions will be based off the words in our dictionary 

where from the first index we check the words against the setting the new index to the length of that string

where after finding a valid word, we update the index and provide the same decisions to that new index as we did to the first one

Where if when we update the index is the length of the string given to us, we can return true

Where we can use a cache 

We would want to cache at what indeces in the word may return false and true

This would help eliminate repeated work

our base case is dp[length of string] is true

we will now go through every index in reverse order

setting the subproblems as true or false in a more so bottom up approach

where dp[0] is dp[0 + length of the word we matched with] which leads up us to the dp[of updated index] and if that is true then dp[0] is true and we can return true
*/