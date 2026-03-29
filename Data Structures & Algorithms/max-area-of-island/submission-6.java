class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // our ouput
        int maxArea = 0;

        // we now iterate over the entire grid
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                // we update our area if find an area greater than the current one stored
                maxArea = Math.max(maxArea, helper(grid, i, j));
            }
        }

        return maxArea;
    }

    // recursive helper function to carry out DFS
    private int helper(int[][] grid, int i, int j){
        // base case

        // check if we go out of bounds
        // we also check if we are on water
        // so we return 0 as we did not find an island
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0) return 0;

        grid[i][j] = 0;

        // recursive case

        // we will now find the area of the island
        // the current cell will count as one
        // we will run dfs on all four directions and add it up
        return 1 + helper(grid, i + 1, j) + helper(grid, i - 1, j) + helper(grid, i, j + 1) + helper(grid, i, j - 1); 
    }
}

/*
We are to return an integer that represents the max area of an island we found

we are a 2D given a grid of 1's and 0's with 1 representing island and 0 being water

The description:

We have a grid with grid[i] being 0, water, 1 which is land

An island is 1's that are connected horizontally and vertically

The area of an island is the number of cells in that island

We want then the maximum area found within our islands

If we have no islands, we return 0

An approach:

We can use DFS to explore all islands and find the areas

We iterate through every cell in the grid

If we find that we are on a '1' that hasn't been visited

We run dfs to explore the whole island and find its corresponding area

We also must keep track of the max area of the island we found

We use a set to keep track of all visited cells

We would set our variable that will keep track of the max area as 0 as because if no islands are found, we must return 0

Then for each cell in the grid

we check if the cell is an island/1

if so, we call dfs to find the area

we would then compare and update the max area with the island we just found

we would then return our max area variable

our dfs function would look something like this

we would check our cell if it is out of bounds or if its water/0, as that is a base case which we return 0

otherwise we would mark the cell as visited

then we call dfs recursively on the right, left, up, and down cell adding it all up with 1 (to account for current cell)

Another approach:

We will be using DFS

We ensure we are in bounds and on land to update area

We keep track of the cells we have visited using a hashset

our dfs returns the area of the current island we are visiting 
*/