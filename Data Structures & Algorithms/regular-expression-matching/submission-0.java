class Solution {
    public boolean isMatch(String s, String p) {
        Map<String, Boolean> map = new HashMap<>();

        return helper(0, 0, s, p, map);
    }

    private boolean helper(int i, int j, String s, String p, Map<String, Boolean> map){
        // base case

        String key = i + "," + j;
        if(map.containsKey(key)) return map.get(key);

        // we check if both i and j indeces are out of bounds
        // if so that means we were able to match all characters
        // we can return true

        // now if i is not out of bounds but j is, then we return false
        // there are characters in s, we couldn't match
        if(j >= p.length()){
            return i == s.length();
        }

        // we want to check if there is a match in the characters
        // or if there is a '.' present
        // while also checking if i is in bound
        boolean match = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));   

        boolean result;

        // we want to check if the next character in the pattern is a *
        // we also check if the next character is in bound
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // when we have a star, we have two choices
            // we either don't use the star
            // we can use the star
            // note we can only use the star if there is a match in the current characters
            result = helper(i, j + 2, s, p, map) || (match && helper(i + 1, j, s, p, map));
            map.put(key, result);
            return result;
        }

        // if we have a match, but no star, we increment both indeces
        if(match){
            result = helper(i + 1, j + 1, s, p, map);
            map.put(key, result);
            return result; 
        }

        map.put(key, false);
        return false;
    }
}

/*
We are given two strings

We are asked to return a boolean

Description:

We are given a string and a pattern 

We have the characters '.' and '*' as well

We want to return true if the pattern can match our string 

The '.' matches any single character 

The '*' matches zero or more of the preceding element

Example:

Input: s = "xyz", p = ".*z"

We can return true

As '.' can map to any character and as * follows it we can have as many '.' as we want and z matches the end of our string

So our pattern can match our string, make this true

An Approach:

We can do top down with memoization

We will have a recursive helper function with the inputs i and j as indeces

Where we will see if we can match the string from i to the pattern from j

Our base case

if our index j is equal to the length of our pattern, we will return i is equal to the length of the string as we need both to match

Recursive case:

We will check if the current characters match or if we are at a '.' in the pattern

Now if we are on a '*' in the pattern

We have two choices

We skip the current character so take 0 occurences of it (dp(i, j+2))

Or

We can use it once or more if the characters in the pattern and string match (dp(i+1, j))

Else we can proceed to the next characters if only the current characters match (dp(i+1, j+1))

Another Approach:

Using decision tree when '*' present
*/