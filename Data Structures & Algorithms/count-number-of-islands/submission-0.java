class Solution {
    public int numIslands(char[][] grid) {
        Set<String> visited = new HashSet<>();
        int count = 0;

        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[0].length; column++){
                if(helperDfs(grid, row, column, visited)) count++;
            }
        }
        return count;
    }
    
    private static boolean helperDfs(char[][] grid, int row, int column, Set<String> visited){
        boolean rowInbounds = 0 <= row && row < grid.length;
        boolean columnInbounds = 0 <= column && column < grid[0].length;
        if(!rowInbounds || !columnInbounds) return false;

        if(grid[row][column] == '0') return false;

        String position = row + "," + column;
        if(visited.contains(position)) return false;

        visited.add(position);

        helperDfs(grid, row - 1, column, visited);
        helperDfs(grid, row + 1, column, visited);
        helperDfs(grid, row, column - 1, visited);
        helperDfs(grid, row, column + 1, visited);

        return true;
    }
}
