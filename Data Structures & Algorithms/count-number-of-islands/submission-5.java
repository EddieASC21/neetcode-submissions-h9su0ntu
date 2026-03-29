class Solution {
    public int numIslands(char[][] grid) {
        // we will make sure our grid isn't empty
        // if so we return 0 as no islands
        if(grid.length == 0) return 0;

        // we want to also to keep track of visited cells
        Set<String> visited = new HashSet<>();

        // we set our return variable
        int count = 0;

        // we want to visit every cell in the grid
        // we will iterate through all row and column
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                // if we visit a '1' we haven't visited then we must carry out our helper function
                if(grid[i][j] == '1' && !visited.contains(i + "," + j)){
                    helper(i, j, grid, visited);
                    count++;
                }
            }
        }

        return count;
    }

    // helper function to carry out bfs
    private void helper(int i, int j, char[][] grid, Set<String> visited){
        Queue<int[]> queue = new LinkedList<>();

        // we mark the current position as visited
        visited.add(i + "," + j);

        // we also add this cell to our queue
        queue.add(new int[]{i, j});

        // we will expand our island as long as the queue is not empty
        while(!queue.isEmpty()){
            // we pop off our processed cell in our queue to then visit its neighbors
            int[] cell = queue.poll();
            // we use cell destructuring to get the row and column
            int row = cell[0];
            int column = cell[1];
            // we now want to process the neighbors

            // we also note the directions we can move in
            // we can up, down, left, right
            int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

            // for each direction
            for(int[] direc : directions){
                // we check if our position is in bounds
                // we use cell destructuring to get the new row and column
                int newRow = row + direc[0];
                int newColumn = column + direc[1];
                // we also ensure we are on land
                // also that position has not been visited
                if(newRow >= 0 && newRow < grid.length && newColumn >= 0 && newColumn < grid[0].length && grid[newRow][newColumn] == '1' && !visited.contains(newRow + "," + newColumn)){
                    // if true we add to our queue as we need to run bfs on this cell as well
                    queue.add(new int[]{newRow, newColumn});
                    // we also must mark it visited
                    visited.add(newRow + "," + newColumn);
                }
            }
        }
    }
}

/*
We are to return an integer 

The integer we would return is the number of islands in our grid

we are given a 2D character array called grid

From the description

We are given a 2D grid of characters with '1' demonstrating land and '0' showing water

We will return the count of number of islands

We denote an island as connected land, connected horizontally and/or vertically and surrounded by water

An approach:

We will be using dfs

So what we will do is when we find a '1', we will mark it as a new island and run dfs on it

What we can do is iterate through each cell in the grid

If the cell we land on is '1', we have found a new island

We add to the island count and run dfs on the cell

We mark all cells that were once islands after visiting as '0' to avoid cycles

We do this until all cells have been checked

Another Approach:

We will be using bfs to visit neighbors in layers
*/
