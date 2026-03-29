class Solution {
    public void islandsAndTreasure(int[][] grid) {
        // we will have a set to keep track of visited positions
        Set<String> visited = new HashSet<>();

        Queue<int[]> queue = new LinkedList<>();

        // we iterate through every cell to find where the treasures are to initialize our queue
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                // if we are on a 0 we add to our queue and mark it as visited
                if(grid[i][j] == 0){
                    queue.offer(new int[]{i, j});
                    visited.add(i + "," + j);
                }
            }
        }

        // directions we can move in
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        // set the distance initialize as 0
        int distance = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            // we go through every position in the queue
            for(int i = 0; i < size; i++){
                // we pop from queue to get the coordinates of the treasure cells as this is the first layer we added
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];

                // go through all position
                for (int[] dir : directions) {
                    int r = row + dir[0];
                    int c = col + dir[1];

                    // we check if we are in bounds, cell hasn't been visited, or not INF as that is a cell we would want to update
                    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != Integer.MAX_VALUE || visited.contains(r + "," + c)) continue;

                    // we set the new distance
                    grid[r][c] = distance + 1;
                    // we add to the queue 
                    queue.offer(new int[]{r, c});
                    // we mark the cell as visited
                    visited.add(r + "," + c);
                }
            }
            // after we iterate a full layer of the queue, we increment the distance by 1
            distance++;
        }
    }
}

/*
We aren't returning anything

we are given a 2D grid of integers

Description:

We are given a m x n 2D grid

The grid has 3 values

-1 represents a water cell that cannot be traversed

0 is a treasure chest

INF is then a cell of land that can be traversed, INF = 2147483647

We want to finll each land cell with its distance to the nearest treasure chest

If from that land cell we cannot reach a treasure chest, the cell stays equal to INF

We can only move up, left, down, or right

We will modify the grid in place

An approach:

We will be using multi source bfs

We will treat every treasure chest as a starting point

We will find the shortest path from every INF cell to a 0 cell

The reason why it is a multi source bfs is because we are running bfs from all 0's at the same time

We will be using a queue

We will initialize the queue with all the coordinates on the grid of the treasure chests

We will run BFS on all these coordinates at the same time

For each step in BFS 

We will move up, down, right, left

now if the position we get to is INF, we overwrite the cell with the value distance + 1 and add it to queue

We will skip when we are out of bounds, on water cell, and cells already visited and overwritten

Each bfs level will add 1 to the distance and marking and overwriting the cell with the shortest path

Another approach:

We will find the treasure

We will run bfs starting from the treasure

We will mark the distance on the cell from the distance from the gate

We run bfs on all gates at the same time so that the minimum distance is found

We travel by layers
*/