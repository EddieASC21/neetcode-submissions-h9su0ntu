class Solution {
    public int uniquePaths(int m, int n) {
        // We will set all of the values in the bottom row to be 1
        // there is only one unique way from every cell in the bottom row to get to the destination and that is going right    
        int[] row = new int[n];

        Arrays.fill(row, 1);

        // we now will go through every row now not including the last one
        for(int i = 0; i < m - 1; i++){
            // we will compute a new row above the bottom row
            int[] newRow = new int[n];

            Arrays.fill(newRow, 1);

            // so to not check out of bounds we will not check against the last column as it is set to always 1
            // it is always set 1 as there is only one unique way from every cell in the last column to get to the destination and that is going down
            for(int j = n - 2; j > -1; j--){
                // we now set the position at j for the new row to be the right value in the new row plus the value under it from the old row
                // overwriting it essentially
                newRow[j] = newRow[j + 1] + row[j];
            } 
            // we update the row to be set to the new row
            row = newRow;
        }

        // we then return our result found in the left upper corner
        return row[0];
    }
}

/*
We are given two integers that are the dimension of the grid

We are asked to return an integer

Description:

We are given a grid where we are given the dimensions as integers 

We can move throughout the grid where we can move down or right at any time

Given the integers representing the dimension, we must return all possible unique paths that we can take to get from the top left corner to the botton right corner

Example:

Input: m = 2, n = 2

Where this means that the grid has 2 rows and 2 columns

So this a 2 x 2 grid

This would mean that we have 2 unique ways

One where we can move down and then right to get from the left upper corner to the bottom right corner

We can also move right then down to  get from the left upper corner to the bottom right corner

These are the only 2 unique ways so we return true

An Approach:

We can build a 2D dp table 

Where we would denote dp[i][j] to represent the number of unique paths to reach the position (i, j)

Base Case:

Our first row and first column will always have only one unique path where we either go completely straight down or right

So then our recurrence relation is dp[i][j] = dp[i-1][j] + dp[i][j-1]

Another Approach:

We can use combinatorics

We note that the total number of moves is (m + n - 2) moves as we add (m - 1) downs + (n - 1) rights

We can choose any (m - 1) moves to be down or any (n - 1) moves to be rights

So our numbers of paths is 

Choose (m + n - 2, m - 1) = (m + n - 2)! / (m - 1)! * (n - 1)!

One Approach:

We have two decisions 

Go down or right

From then we have the same two choices until we can no longer go down or right

We note that there will be repeated work as we can get to the same position in multiple ways

If we have cache, we will store the number of ways we can reach the destination from a certain position

The base case is from the ending position there is 1 unique way to get to itself and build up from there

We will set the values out of bounds as 0

For every position in the bottom row there is only one way to get to the destination

We will then fill the table adding up its value found in the cell under and to the right of it

Note that the last column will be filled of ones as we can only go down

The answer would then be at the starting position adding the values under it and to the right of it
*/