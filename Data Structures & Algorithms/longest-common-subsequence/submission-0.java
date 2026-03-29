class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // we will have a 2D grid
        int[][] grid = new int[text1.length() + 1][text2.length() + 1];

        // we will initialize the entire grid cells to be 0
        for(int i = 0; i <= text1.length(); i++){
            for(int j = 0; j <= text2.length(); j++) grid[i][j] = 0;
        }

        // we will now iterate over the entire grid in reverse order
        for(int i = text1.length() - 1; i > -1; i--){
            for(int j = text2.length() - 1; j > -1; j--){
                // if both characters match, we set the cell to be 1 + the diagonal
                if(text1.charAt(i) == text2.charAt(j)) grid[i][j] = 1 + grid[i + 1][j + 1];
                // if they don't match, we this cell to the greater value in the down or right cell
                else grid[i][j] = Math.max(grid[i + 1][j], grid[i][j + 1]);
            }
        }

        // the result is in the first cell as bottom up
        return grid[0][0];
    }
}

/*
We are given two strings

We are asked to return an integer

Description:

We are given two strings

Where we want to return the length of the longest common subsequence between the 2 strings, if we can't find one we return 0

A subsequence is a sequence where we can delete or not delete elements without changing the order

One example is that cat is a subsequence of crabt

A common subsequence of 2 strungs is a subsequence that exists in both strings

Example:

Input: text1 = "cat", text2 = "crabt" 

The longestest common subsequence is cat as it appears in the first string and the second string after deletions

As the longest common subsequence is cat we return 3

An Approach:

We will keep track of a 2D dp table

Where dp[i][j] is the length of the longest common subsequence between:

from the first i characters of the first string (String 1 from index 0 to i - 1)

and the first j characters of the second string (String 2 from index 0 to j - 1)

Our recurrence relationship:

if String1[i - 1] is equal to String2[j - 1] then dp[i][j] = 1 + dp[i - 1][j - 1]

Else dp[i][j] is the max value of dp[i - 1][j] or dp[i][j - 1]

This means that 

If the characters match then we can take the character and increase the LCS length by 1

Else we will skip one character from String 1 or String 2 and take the better resut

So

We will initialize a 2D array dp of size of length of String 1 plus 1 multiplied by the length of String 2 plus 1 to 0

We will fill in this 2D array using the rules we said

Our answer will be in the cell dp[length of string 1][length of string 2]

Another Approach:

If we start at the beginning of both strings

if they match, then we will break this into a subproblem where we find the LCS of the remainder of both strings + 1 

And another subproblem is if they don't match that the LCS can be in between the first string and skipping one character in the second string or vice versa

We take both input strings and use it to make a 2D grid

When we go out of bounds, the value we find in that cell is 0

so as we said that the 2D grid dimensions is made from the length of the strings + 1

That extra column and row (last row and last column) are set to 0

As we note that a string that is not empty and empty string have an LCS of 0

When we find a matching characters we add 1 to the LCS

We return the LCS length in the first cell

We look at the character and see if they match so that we can set the cell as 1 + the diagonal

We will do this for every cell

If characters don't match we will look down or right and take the max value and assign it to that cell
*/