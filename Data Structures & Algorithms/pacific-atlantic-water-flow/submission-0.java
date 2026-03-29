class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // our output
        List<List<Integer>> output = new ArrayList<>();

        // we get the dimensions 
        int rows = heights.length, cols = heights[0].length;

        // we will have two hash sets to keep track of the cells that can reach these oceans
        Set<String> pacific = new HashSet<>();
        Set<String> atlantic = new HashSet<>();

        // we go through every column in the first row 
        // as these are positions that reach the pacific
        for(int i = 0; i < cols; i++){
            // we want to keep track of the previous height to ensure we can create a valid path
            helper(heights, 0, i, pacific, heights[0][i], rows, cols);
            // we go through the columns of the last row as this connects the atlantic
            helper(heights, rows - 1, i, atlantic, heights[rows - 1][i], rows, cols);
        }

        // we go through the rows of the first column
        // this connects to the pacific
        // we also go through the rows of the last column
        // this connects to the atlantic
        for(int i = 0; i < rows; i++){
            helper(heights, i, 0, pacific, heights[i][0], rows, cols);
            helper(heights, i, cols - 1, atlantic, heights[i][cols - 1], rows, cols);
        }

        // we go through every cell
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                // we check if the cell is in both our sets
                // if so this cell can reach both oceans
                if(pacific.contains(i + "," + j) && atlantic.contains(i + "," + j)) output.add(Arrays.asList(i, j));
            }
        }

        return output;
    }
    
    // helper function to carry out dfs
    private void helper(int[][] heights, int i, int j, Set<String> visited, int previousHeight, int rows, int cols){
        // base case
        
        // if we have visited the cell, we return
        // if we are out of bounds, we retun
        // we also return if the current cell's height is less than the previous cell
        if(visited.contains(i + "," + j) || i < 0 || j < 0 || i == rows || j == cols || heights[i][j] < previousHeight) return;

        // we add to our visited set our set we are now visiting
        visited.add(i + "," + j);

        // recursive case

        // we visit all neighbors
        helper(heights, i - 1, j, visited, heights[i][j], rows, cols);
        helper(heights, i + 1, j, visited, heights[i][j], rows, cols);
        helper(heights, i, j - 1, visited, heights[i][j], rows, cols);
        helper(heights, i, j + 1, visited, heights[i][j], rows, cols);
    }
}

/*
We are to return a list of list of integers

we are given a 2D grid of integers

Description:

We are given a rectangular island heights

We note that heights[r][c] is the height above sea level for a cell (r, c)

The island borders the Pacific Ocean from the top and left sides

The island borders the Atlantic Ocean from the bottom and right sides

We note that the water can flow up down left or right from a cell to its neighbor that has a height equal or lower to itself

Water can also flow into the ocean from cells adjacent to the ocean

We want to find the cells where the water can flow from that cell to both oceans

We will return it as a 2D list with (r, c) representing the cell

An approach:

We note that water flows from high to low/equal height

We want to find cells that have valid paths to both oceans

So instead of seeing if a path exists from every cell what we can do is start from the ocean inward to find the cells that are valid

We can do a reverse flood fill

We can have two visited matrices

one for if the cell reaches the pacific and another for if the cell reaches the atlantic

we start the algorithm from ocean adjacent cells

so we begin for the pacific with the first row and first column

we begin the atlantic with the last row and last column

We only allow a path to be built along cells height is greater than or equal to the previous cell as we are doing reverse flood fill

We add to the output if the cells are reachable to both oceans

Another approach:

We will find every cell that borders the pacific ocean to begin

The first row borders the pacific ocean and every cell in it can reach the pacific as well as the left column

So starting fro the first row and left most column, we will find the other nodes that can reach the pacific

We do the same with the atlantic as the last row and right most column can reach the atlantic

Since we are starting outward in, we must go to cells that are greater or equal height
*/
