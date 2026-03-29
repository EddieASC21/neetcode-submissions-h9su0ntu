class Solution {
    public int orangesRotting(int[][] grid) {
        // we create our queue
        Queue<int[]> queue = new LinkedList<>();

        // we will keep track of time and how many fresh fruit in the grid
        int time = 0, fresh = 0;

        // we iterate of the entire grid
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                // we count the number of fresh oranges
                if(grid[i][j] == 1) fresh++;
                // we find and keep track the positions of our rotten oranges
                // we then add this position to our queue
                if(grid[i][j] == 2) queue.offer(new int[]{i, j});
            }
        }

        // the directions we can take
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 

        while(!queue.isEmpty() && fresh > 0){
            // we want to pop by layers from our queue
            int size = queue.size();
            // this loop will run for the size of the queue which is the current layer
            for(int i = 0; i < size; i++){
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];

                // we now will iterate over the neighbors
                for(int[] dirc : directions){
                    // we find our new row and col when visiting the neighbor
                    int newRow = dirc[0] + row, newCol = dirc[1] + col; 

                    // we ensure this new position is in bound and is originally a 1, a fresh orange
                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1){
                        // we now mark the cell as a rotten orange
                        grid[newRow][newCol] = 2;
                        // we add this position to our queue, our newly rotten fruit
                        queue.offer(new int[]{newRow, newCol});
                        // we decrement the amount of fresh fruit 
                        fresh--;
                    }
                }
            }

            // we increment our time after processing a layer
            time++;
        }

        // we can return the time if fresh fruits are 0 else we must return -1
        return fresh == 0 ? time : -1;
    }
}

/*
We are to return an int

We are given a 2D grid of integers

Description:

We have a 2D matrix

Where each cell can have 1 of the 3 values

The values are

0 is an empty cell 

1 is a cell with fresh fruit

2 is a cell with rotten fruit

At every minute if a fresh fruit is next to (up, down, left or right) a rotten fruit, it will become rotten

We will return the minimum number of minutes until we have 0 fresh fruit

Else we return -1

Example:

Minute: 0

grid = [[1,1,0],
        [0,1,1],
        [0,1,2]]

Minute: 1

grid = [[1,1,0],
        [0,1,2],
        [0,2,2]]

Minute: 2

grid = [[1,1,0],
        [0,2,2],
        [0,2,2]]

Minute: 3

grid = [[1,2,0],
        [0,2,2],
        [0,2,2]]

Minute: 4

grid = [[2,2,0],
        [0,2,2],
        [0,2,2]]

We now have all rotten oranges and the minimum time is 4 minutes

An approach:

We will be using multi source bfs

We will have a queue that will be initialized with all the positions where we have rotten oranges

We keep track of the total number of fresh fruit to begin to know when all have rotten later on

We would run bfs where every new layered explored is 1 minute

For each rotten fruit in queue, we will infect its fresh neighbors

Then we will add to queue the new rotten fruit

When the queue is empty we check if we have any fresh fruit left

if so we return -1 else return the time in minutes that have passed

Another approach:

We will use multi source bfs

We will use a queue

We will initialize the queue with the positions of the rotten oranges

infect the neighbors that are fresh and add the infected neighbors to the queue

wwe stop when the queue is empty or when the fresh oranges is 0

So we must keep track of the fresh oranges initially
*/
