class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        
        int lip = 0;

        // we iterate over the entire grid
        // we want to run dfs on every cell
        // we set previous value as -1 as all values are positive and there will be a path
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                lip = Math.max(lip, helper(i, j, -1, matrix, map));
            }
        }

        return lip;
    }
    
    // recursive helper function
    private int helper(int i, int j, int prev, int[][] matrix, Map<String, Integer> map){
        // base case

        // we want check if we went out of bounds
        // we also check if the current cell is greater than the previous one to continue the path
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= prev) return 0;

        // we check if we already computed the longest increasing path at this cell
        String key = i + "," + j;
        if(map.containsKey(key)) return map.get(key);

        // recursive case

        // we set the result as 1 as the current counts as a longest increasing path
        int result = 1;

        // we try every direction
        // we add 1 to the path as a greater cell found
        result = Math.max(result, 1 + helper(i + 1, j, matrix[i][j], matrix, map));
        result = Math.max(result, 1 + helper(i - 1, j, matrix[i][j], matrix, map));
        result = Math.max(result, 1 + helper(i, j + 1, matrix[i][j], matrix, map));
        result = Math.max(result, 1 + helper(i, j - 1, matrix[i][j], matrix, map));

        map.put(key, result);

        return result;
    }
}

/*
We are given a 2D integer array

We are asked to return an integer

Description:

We are given a 2D grid filled with integers

Each integer is greater than or equal to 0

We are to return the length of the longest increasing path 

Fo each cell in the path we can only move up, down, right, left

Example:

Input: matrix = [[1,2,3],[2,1,4],[7,6,5]]

The answer is 7

The reason is there exits a path of length 7: [1, 2, 3, 4, 5, 6, 7]

An Approach:

We will use dfs and cache subproblems

At each cell we can branch out to 4 different directions

We will run dfs at each cell to compute the longest increasing path starting from that cell

We will use a cache to memoize the result of each cell

At each cell, we will try all directions where we only move to the next cell if it has a greater value than the current one

We then return the maximum length found

Another Approach:

We can run dfs on each cell with a 2D grid to keep track of each longest increasing path in each cell

We always mark the cell as 1 to begin with as the number in the cell can be a longest increasing path by itself

Where if we find at this cell, there is a neighbor cell with a greater value, we run dfs

We move to the next cell we would run dfs on and check if we have already computed the longest increasing path at that cell

After computing the entire 2D table, we return the greatest value in the table
*/