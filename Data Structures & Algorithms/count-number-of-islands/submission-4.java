class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        Set<String> visited = new HashSet<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(islands(grid, i, j, visited)) count++;
            }
        }
        return count;
    }

    private static boolean islands(char[][] grid, int i, int j, Set<String> visited){
        String pos = i + "," + j;

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited.contains(pos)) return false;

        visited.add(pos);

        islands(grid, i - 1, j, visited);
        islands(grid, i + 1, j, visited);
        islands(grid, i, j - 1, visited);
        islands(grid, i, j + 1, visited);

        return true;

    }
}
