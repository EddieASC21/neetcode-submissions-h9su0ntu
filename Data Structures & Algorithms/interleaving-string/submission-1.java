class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // we ensure that the length of the first and second string can add up to the third strings length
        // if not that means we don't have enough characters and return false
        if(s1.length() + s2.length() != s3.length()) return false; 

        // we initialize our 2D dp table
        // where we set everything to be false to begin 
        // we will set the last value as true as that means that two empty strings are equal
        // empty strings are equal means all characters have been used 
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[s1.length()][s2.length()] = true;

        // we will now work our way up
        for(int i = s1.length(); i >= 0; i--){
            for(int j = s2.length(); j >= 0; j--){
                // we check that our index is inbounds
                // if inbounds, we want tp check if the character at i is the same as the character of i + j (pointer for string 3)
                // we also check that the neighbor is true
                if(i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) dp[i][j] = true;
                if(j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) dp[i][j] = true;
            }
        }

        return dp[0][0];
    }
}

/*
We are given three strings and must return a boolean

Description:

We are given three strings

We want to return true if the third string can be made interleaving the first and second string together

We will return false if we can't

Interleaving two strings is done by dividing the strings into substrings where

The difference between the number of substrings of the two strings is at most 1

Interleaving the two strings can be the first substring of string 1 and the first substring of string 2 or first substring of string 2 and the first substring of string 1

We can assume that all the characters in the 3 strings are lowercase english letters

Example:

Input: s1 = "aaaa", s2 = "bbbb", s3 = "aabbbbaa"

We can take the first substring of s1 as aa and then can take the substring of s2 as the entire string and take the last substring of s1 to get s3

As we have 2 substrings from s1 and 1 substring from s2 and 2 - 1 is 1 so we can return true

An Approach:

We check if the length of the first and second string is equal to the third string else we return false

We will use dfs and memoization

We will define our recursive function

The function will intake two indeces keeping track of the position in the first and second string

Where the helper function returns true if we can form the third strings using the substrings of string one and two

Our base case

If the index of string one is the length of the first string and the index of string second is the length of the second string, we check if those indeces summed is equal to the length of the third string

Our recursive case

We try taking from the first index of the first string and if it matches the third string in the first and second index

We can try taking from the second index of the second string and if it matches the third string in the first and second index

We will store the indeces in our cache to avoid recomputation of sub problems

Another Approach:

We can use a decision tree

When looking at a character in the third string

We want to see if we can get the character from string one or two

We will have to pointers to represent what index we are on in the strings

We notice that the pointer of the third string is the addition of the pointers in the first and second string

We update the pointers of each string with every decision we make

We can also cache subproblems

The key will be the indeces of the pointers in the string with the value being a boolean which is if we can form the remaining portion of the third string

If we find a true, we will return true right away

Yet we can also do a bottom up approach

We will have a 2D table with the dimensions being the length of the first string and the length of the second string 

The base case has to deal with if both pointers reach out of bounds where we can mark that cell as true

Where for the columns and rows that deal with a character and empty string, we will check if we can mark as true or false

A cell is dependent on the neighbors

If we take a character from the first or second string, it will determine what cell we look up if either down and to the right and determine that value based on the cell

If we take both characters, we can check both down and right and mark it dependent on that
*/