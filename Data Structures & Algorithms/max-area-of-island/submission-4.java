class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        Set<String> visited = new HashSet<>();

        // set to zero and not min integer value as island can't be negative
        int maxArea = 0;

        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j++){
                int currArea = search(grid, i, j, visited);
                if(currArea > maxArea) maxArea = currArea;
            }
        }
        return maxArea;
    }

    private static int search(int[][] grid, int i, int j, Set<String> visited){
        String pos = i + "," + j;

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited.contains(pos)) return 0;

        visited.add(pos);

        int size = 1;

        size += search(grid, i - 1, j, visited);
        size += search(grid, i + 1, j, visited);
        size += search(grid, i, j - 1, visited);
        size += search(grid, i, j + 1, visited);

        return size;

    }
}
