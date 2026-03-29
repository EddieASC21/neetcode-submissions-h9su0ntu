class Solution {
    public int numDecodings(String s) {
        // we create a memo map 
        Map<Integer, Integer> map = new HashMap<>();

        // add the length of string as a key and assign it to the value 1
        // this is a base case for an empty string
        // empty string has one way to decode
        map.put(s.length(), 1);

        // we call our helper function on the first index
        return helper(s, 0, map);
    }

    // recursive helper function
    private int helper(String s, int index, Map<Integer, Integer> map){
        // we chcek if the subproblem has been cached
        if(map.containsKey(index)) return map.get(index);

        // we check if the first digit to our new substring is a 0 as has no ways to decode so return 0
        if(s.charAt(index) == '0') return 0;

        // we now run dfs on the next index
        // this means we choose one character
        int result = helper(s, index + 1, map);

        // we now choose two characters
        // we check if we have enough to choose two characters
        // we check to ensure that the 2 characters is in range 10 to 26
        if (index + 1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                result += helper(s, index + 2, map);
            }
        }

        // we cache our result
        map.put(index, result);

        return result;
    }
}

/*
We are given a string and want to return an integer

Description:

We have a string that contains all uppercase letters

these characters can be encoded to a number using the following mapping

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"

To decode a message:

the digits must be grouped 

then mapped back to letters using the reverse mapping 

there may be multiple mays to decode a message

Given a string that contains only digits

we want to return the number of ways we can decode it

Example

Input: s = "1012"

This can be mapped to

We can have "JAB" with the grouping of (10 1 2)

and 

We can also have "JL" with the grouping (10, 12)

So we return 2 

As (1 0 1 2) is not a valid grouping as 0 maps to nothing and (1 01 2) is invlaid as we can't have any leadung 0's

An approach:

We note:

We can decode a single character if it is in the range of '1' to '9'

We can decode two characters if it is in the range of '10' to '26'

0 is a special case

0 can't decoded

the only times a digit containing 0 can be decoded is '10' and '20'

We will use an array

where array[i] is used to represent the number of ways we can decode the substring string.substring(0, i - 1)

We initialize array[0] = 1 as an empty string has one way to decode which is a base case

we also initialize array[1] = 1 if string.charAt(0) is not 0 else we will set it as 0

From then for each index 2 to the length of the string

We do a single digit check where if string.charAt(i - 1) != 0, we add array[i - 1]

We also do a double digit check where if string.substring(i - 2, i - 1) is between '10' and '26', we can add array[i - 2]

Another Approach:

We can use a decision tree

one branch where we take one character as long as it is not 0

next branch take 2 characters as long as it is not a leading zero and between 10 and 26

where the base case is if we can reach the end of a string in a brach and return the number of valid branches

The subproblem is when we take one or two characters, we ask how many different ways we can decode the remaining of the string

We will keep track of the 2 positions coming after it to help find the number of ways to decode
*/