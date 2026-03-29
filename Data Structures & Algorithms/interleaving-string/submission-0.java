class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // memoization solution 

        // we check if we can even recreate strung 3 from the first and second oen, if not we return false right away
        if (s1.length() + s2.length() != s3.length()) return false;

        Map<String, Boolean> map = new HashMap<>();

        return helper(s1, s2, s3, 0, 0, map);
    }

    // recursive helper function
    private boolean helper(String s1, String s2, String s3, int idx1, int idx2, Map<String, Boolean> map){
        // base case

        // if both indeces can reach the end of their respective strings, that means we can use all the characters to recreate string 3 and so return true
        if(idx1 == s1.length() && idx2 == s2.length()) return true;

        // we check if we have computed this subproblem and has been stored in our cache
        String key = idx1 + "," + idx2;
        if(map.containsKey(key)) return map.get(key);

        // recursive case

        // we check if our index is in bound and the character at this index matches the character in the 3rd string given this index plus the other index
        // we will then recursively call it with updating the index 
        // this will return return as long as we can recursively call it until it hits a base case
        if(idx1 < s1.length() && s1.charAt(idx1) == s3.charAt(idx1 + idx2) && helper(s1, s2, s3, idx1 + 1, idx2, map)) return true;
        if(idx2 < s2.length() && s2.charAt(idx2) == s3.charAt(idx1 + idx2) && helper(s1, s2, s3, idx1, idx2 + 1, map)) return true;

        // we will store the failed subproblem as if we ever can, we want to return true right away
        map.put(key, false);

        return false;
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