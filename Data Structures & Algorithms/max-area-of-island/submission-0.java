class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        Set<String> visited = new HashSet<>();
        int maxArea = Integer.MIN_VALUE;

        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[0].length; column++){
                int size = (helperDfs(grid, row, column, visited));
                if(size > maxArea) maxArea = size;
            }
        }
        return maxArea;
    }
    
    private static int helperDfs(int[][] grid, int row, int column, Set<String> visited){
        boolean rowInbounds = 0 <= row && row < grid.length;
        boolean columnInbounds = 0 <= column && column < grid[0].length;
        if(!rowInbounds || !columnInbounds) return 0;

        if(grid[row][column] == 0) return 0;

        String position = row + "," + column;
        if(visited.contains(position)) return 0;

        visited.add(position);
        int size = 1;

        size += helperDfs(grid, row - 1, column, visited);
        size += helperDfs(grid, row + 1, column, visited);
        size += helperDfs(grid, row, column - 1, visited);
        size += helperDfs(grid, row, column + 1, visited);

        return size;
    }
}
