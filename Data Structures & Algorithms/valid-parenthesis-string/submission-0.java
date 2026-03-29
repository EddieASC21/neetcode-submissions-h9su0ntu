class Solution {
    public boolean checkValidString(String s) {
        // we keep track of the minimum and maximum number of open paranthesis we can have
        int openMin = 0, openMax = 0;

        // we now iterate through every character in the string
        for(char c : s.toCharArray()){
            // if we have an open paranthesis, we increment both variables
            if(c == '('){
                openMin++;
                openMax++;
            }
            // if we have a closing paranthesis, we must decrement both variables
            else if(c == ')'){
                openMin--;
                openMax--;
            } 
            // if we have a wildcard
            // we can choose to have a close paranthesis, we decrement the openMin
            // we can choose to have a open paranthesis, we increment the openMax
            else{
                openMin--;
                openMax++;
            }

            // if the openMax is negative, we return false as we have too many open paranthesis unmatched
            if(openMax < 0) return false;

            // if the openMin is negative, we must reset the varaible
            if(openMin < 0) openMin = 0;
        }

        return openMin == 0;
    }
}

/*
We are given a string

We want to return a boolean

Description:

We are given a string

The string contains only 3 characters:

'('
')'
'*'

We want to return true if s meets the following requirements

Every left paranthesis, '(', has a matching right paranthesis, ')'

Every right paranthesis, ')', has a matching left paranthesis '('

The left paranthesis, '(', must be before the matching right paranthesis, ')'

A '*' can be seen as a right paranthesis, ')', or as a left paranthesis, '(', or as an empty string, ""

Example:

Input: s = "((**)"

We note that we have 2 left paranthesis and one right one

So we are missing one right paranthesis 

We have 2 * where we can use one as a right paranthesis 

we then have an extra * which we can treat as an empty string as both left and right paranthesis are all matching

An Approach:

We will keep track of a range of possible unmatched open paranthesis

We will use two variables

One is the minimum number of possible open paranthesis given that * is considered as a closed paranthesis or empty string

Another one to keep track of the maximum number of possible open paranthesis given that * is an open paranthesis

The first variable would keep track of where * is a closed paranthesis every time which reduces the open count/matches

the second variable keeps track of where * is an open paranthesis every time which increases the open count/matches

if the first variable drops below 0, we reset it to 0 as we can't have less than 0 open paranthesis

if the second variable drops below 0, we return false as we have too many unmatched closed paranthesis 

Another Approach:

We will keep track the number of open paranthesis unmatched

We also need to account of what the wild card may be 

We would have two variables to keep track of the open paranthesis maximum and minimum amount we can have dependent on the wild card

With the two variables we will have one where the wild card is an open paranthesis and the other is a closed paranthesis

We also ensure that the minimum number of open paranthesis is never negative, so we always ensure if we get to it, we reset it to 0

We can return true if the minimum number is 0

If the maximum number ever becomes negative, we return false as we don't have enough open paranthesis to matching the closing
*/