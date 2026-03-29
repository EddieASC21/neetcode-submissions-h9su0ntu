class Solution {
    public String longestPalindrome(String s) {
        // we initialize our result to an empty string
        String result = "";

        // the max length is initialized as 0
        int resultLength = 0;

        // we iterate through every index considering it as the center
        for(int i = 0; i < s.length(); i++){
            // we check odd length palidromes
            // we will have left and right pointers
            // the pointers will be initialized to i which is currently our centers
            int left = i, right = i;

            // we start in the middle and expand outwards
            // we continue while our pointers are inbound and we have a valid palidrome
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                // we know this is a palidrome so we update our result by checking against the lengths
                // we update the result if greater and the result length
                if(right - left + 1 > resultLength){
                    result = s.substring(left, right + 1);
                    resultLength = right - left + 1;
                }

                // we expand our pointers outward
                left--;
                right++;
            }

            // we will now check even length palidromes
            int newLeft = i, newRight = i + 1;
            while(newLeft >= 0 && newRight < s.length() && s.charAt(newLeft) == s.charAt(newRight)){
                if(newRight - newLeft + 1 > resultLength){
                    result = s.substring(newLeft, newRight + 1);
                    resultLength = newRight - newLeft + 1;
                }

                newLeft--;
                newRight++;
            }
        }

        return result;
    }
}

/*
We are given a string

We are also to return a string

Description:

We are given a string

We want to return the longest substring within s that is a palidrome

Where a palidrome is a string that reads the same forward and backward

If we have multiple palidromic substrings of the same length, we are able to return which ever one

Example:

Input: s = "abbbcc"

The answer is bbb as it is a palidrome and has a greater length than the other palidrome, cc

Another Approach:

We will use the expand around center technique 

We note that a palidrome mirrors around the center

SO our idea is to expand around every center and keep track of the longest palidrome found

If the string has a length of n

then the string has 2n - 1 centers

We can see every single character as a possible center (n odd-length centers)

We also can see every pair of characters as a possible center (n - 1 even-length centers)

So

we will iterate through each index in the string

For each index of i we can do the following:

Expand around i (odd-length palidrome)

Expand around i and i + 1 (even-length palidrome)

We will also have a helper function

The helper function will check if it is a palidrome, expand, and return the bounds of the palidrome

Then we will update the bounds if a larger palidrome has been found

Another Approach:

We can start from the middle and expand outward checking if it is a palidrome

we consider each character as a center and expand from there

we can take a center and expand each side giving us odd length palidromes
*/