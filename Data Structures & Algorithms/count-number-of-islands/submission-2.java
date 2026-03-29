class Solution {
    public int numIslands(char[][] grid) {
        // set a set to keep tracks of the cells visited
        Set<String>visited = new HashSet<>();

        // keep track of islands explored
        int numOfIslands = 0;

        // now iterate over every cell possible
        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[0].length; column++){
                // if on an island call helper method
                // once helper function is done, add to count
                if(explore(grid, row, column, visited)) numOfIslands++;
            }
        }

        // after visited every cell, return the number of islands
        return numOfIslands;  
    }

    // recursive dfs helper function 
    private static boolean explore(char[][] grid, int row, int column, Set<String> visited){
        // base cases 

        // set what is inbounds
        boolean rowInBounds = (0 <= row) && (row < grid.length);
        boolean columnInBounds = (0 <= column) && (column < grid[0].length);
        
        // check if we are in bounds when making our recursive calls
        if(!rowInBounds || !columnInBounds) return false;

        // check if we are on water 
        if(grid[row][column] == '0') return false;

        // now we will create positions for the cells 
        // we create these positions into strings to store in set 
        String position = row + "," + column;

        // check if we have visited the position we are now
        if(visited.contains(position)) return false;

        // add the current position we are on
        visited.add(position);

        // recursive call
        explore(grid, row - 1, column, visited);
        explore(grid, row + 1, column, visited);
        explore(grid, row, column - 1, visited);
        explore(grid, row, column + 1, visited);

        // we return to say we have explored an island
        return true;

    }

}
