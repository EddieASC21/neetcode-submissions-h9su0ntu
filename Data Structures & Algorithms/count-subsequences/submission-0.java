class Solution {
    public int numDistinct(String s, String t) {
        Map<String, Integer> map = new HashMap<>();

        return helper(0, 0, s, t, map);
    }   

    // recursive helper function
    private int helper(int i, int j, String s, String t, Map<String, Integer> map){
        // base case

        // if j is equal to the length of string t, that means we have matched all characters and left with empty string
        // we can return 1 as a subsequence was if
        if(j == t.length()) return 1;

        // if i is equal to the length of string s, that means we are left with no characters to match to t
        // we then return 0
        if(i == s.length()) return 0;

        // we check if this subproblem has been computed in our cache
        String key = i + "," + j;
        if(map.containsKey(key)) return map.get(key);

        // recursive case
        
        int count = 0; 

        // if i of s and j of t is equal that means we can use this or skip it
        // if we use we increment both indeces and if we skip we only update i
        if(s.charAt(i) == t.charAt(j)) count += helper(i + 1, j + 1, s, t, map) + helper(i + 1, j, s, t, map);
        // if there is no match at i and j, we skip i so we increment it
        else count += helper(i + 1, j, s, t, map);

        // we store in our cache
        map.put(key, count);

        return count;         
    }
}

/*
We are given two strings

We are asked to return an integer

Description:

We are given two strings 

We want to return the number of distinct subsequences of one string that is equal to the next string

Example:

Input: s = "caaat", t = "cat"

We can have one subsequence where we use the first a, the second a, or the thurd a

With ever a we use, we use c and t

With this we can return 3

An Approach:

A subsequence is a sequence where we can delete zero or multiple characters from a string without changing the relative order of the remaining characters

We can use a 2D dp table

Where we let dp[i][j] be the number of distinct ways we can make the substring of the second string at index j using the substring of the first string at index i

With the recursive relationship:

Where if any position i in the first string and any position j in the second string

if index i in the first string and the index j in the second string are equal (s[i] == t[j])

We can use the match (dp[i+1][j+1])

Or

We can skip it (dp[i+1][j])

So it can look like this: dp[i][j] = dp[i+1][j+1] + dp[i+1][j]

if at these indeces in these strings are not equal (s[i] != t[j])

We skip the ith index in the first string (dp[i+1][j])

This then is dp[i][j] = dp[i+1][j]

We set our base cases as

if the index j is equal to the length of the second string we return 1 as we have matched all the characters in the second string

Now if the index i is equal to the length of the first string and the index j is less than the length of the second string, we reach 0 as we could not match every character in the second string

Another Approach:

if at i in s is equal to j in t

We increment i and j to point to the next character

If they do not match, we only increment i as we want to sure we can match every character in t

if both strings are empty, we have matched every character and can return 1

Note if two characters match in s and t, doesn't mean we have to use it, we can skip it

so for if at i in s is equal to j in t

We can:

We increment i and j to point to the next character or increment just i to skip it

We can use dfs and memoization to cache repeated subproblems

Base cases

if t is empty and we still have characters in s, we can only have one subsequence where we don't take the characters, so we can return 1

If both strings are empty we can return one 

Now if t has characters left and s doesn't we can return 0 as we cannot add characters to help match all of t


*/