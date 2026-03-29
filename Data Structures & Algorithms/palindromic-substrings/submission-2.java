class Solution {
    public int countSubstrings(String s) {
        int result = 0;

        for(int i = 0; i < s.length(); i++) result += helper(s, i, i) + helper(s, i, i + 1);
        
        return result;
    }

    // helper function
    private int helper(String s, int left, int right){
        int count = 0;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }

        return count;
    }
}

/*
We are given a string and ask to return an integer

Description:

We are given a string

We want to return the nu,ber of substrings in the string that are palidromes

Example:

Input: s = "aaab"

This would return 7

The reason is each a is a palidrome and that is 3

aa, aa, and aaa are a palidrome so that's 3

b is a palidrome so that is 1

3 + 3 + 1 = 7

We note that different substrings are counted as different palidromes even if the palidrome strings are the same

An Approach:

We will use the expand around center technique 

We note that a palidrome mirrors around the center

So for every index in the string

We can expand outward to check all palidromes centered at this index

We will check for both:

odd-length palidromes where they are centered at i

and

even-length palidromes where they are centered at i and i + 1

The steps are 

We set our conter as 0

we iterate over each index in the string and treat it 

for each center, we will expand around it for odd and even length palidromes

Every time we find a valid palidrome, we increment the counter

Another approach:

We will find all palidromic substrings that our index is the center of

class Solution {
    public int countSubstrings(String s) {
        // we will keep track of a result variable
        int result = 0;

        // we go through every index and expand 
        for(int i = 0; i < s.length(); i++){
            // odd length palidromes
            int left = i, right = i;

            // while the pointers are in bounds and the characters at these pointers are equal means we found a palindrome
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                // we increment our pointers
                result++;
                // we update our pointers
                left--;
                right++;
            }

            // even length palidromes
            int newLeft = i, newRight = i + 1;
            while(newLeft >= 0 && newRight < s.length() && s.charAt(newLeft) == s.charAt(newRight)){
                result++;
                newLeft--;
                newRight++;
            }
        }

        return result;
    }
}
*/