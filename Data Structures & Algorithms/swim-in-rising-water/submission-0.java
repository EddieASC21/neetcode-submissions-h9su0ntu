class Solution {
    public int swimInWater(int[][] grid) {
        // we get the length of the grid
        int n = grid.length;

        // we will have a set to ensure we don't visit the same coordinates 
        Set<String> set = new HashSet<>();

        // we will havea minheap 
        // the value/what we are minimizing will be comparing the time/maximum height, the key
        // we also will add the coordinates
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // we initialize the heap with the top left cell of the grid
        minHeap.offer(new int[]{grid[0][0], 0, 0});

        // we add the first cell to our visited set
        set.add(0 + "," + 0);

        // we keep track of the four directions we can travel in
        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};

        // we continue while our min heap is not empty
        while(!minHeap.isEmpty()){
            // we pop from the heap
            int[] curr = minHeap.poll();

            // we check if this is the final cell, bottom right corner
            // if so, we have reached the final destination and so we return the time needed
            if(curr[1] == n - 1 && curr[2] == n - 1) return curr[0];

            // we visit the four neighbors for the cells
            // the frontiers
            for(int[] dirc : directions){
                // we update the row and column to the neighor
                // we ensure that these neighboring cells are in bounds and have yet not been visited
                if(curr[1] + dirc[0] >= 0 && curr[1] + dirc[0] < n && curr[2] + dirc[1] >= 0 && curr[2] + dirc[1] < n && !set.contains((curr[1] + dirc[0]) + "," + (curr[2] + dirc[1]))){
                    // we now mark this position as visited
                    set.add((curr[1] + dirc[0]) + "," + (curr[2] + dirc[1]));
                    // we add this cell to the min heap
                    // we add the key of the maximum of the current and previous cell values along this path
                    minHeap.offer(new int[]{Math.max(curr[0], grid[curr[1] + dirc[0]][curr[2] + dirc[1]]), curr[1] + dirc[0], curr[2] + dirc[1]});
                }
            }
        }

        return -1;
    }
}

/*
We are given a 2D array of integers

We want to return an integer

Description:

We are given a 2-D matrix of distinct integers 

Where matrix[i][j] represents the elevation at position (i, j)

When rain starts to fall at time 0, this causes the water to rise

At time t, the water level across the entire grid is t

We can swim either horizontally or vertically in the grid between neighboring cells 

As long as the origianl evaluation of both squares is than or equal to teh water level at time t

We are to start from the top left square (0, 0)

We want to return the minimum amount of time it will take until we can reach the bottom right square (n - 1, n - 1)

Example:

Input: grid = [[0,1],[2,3]]

We start at (0, 0) with a value of 0 and time of 0

We can then reach the neighboring cell with the value 1 with the time of 1

We then have to wait till time is 3 to reach next cell that has a value of 3 which is bottom right square

So we return a value of 3

An Approach:

We can use something similar to dijkstras algorithm

We will havea min heap that stores the evelation, x, and y

we start from (0, 0) with evelation grid[0][0]

we maintain a visited matrix to avoid revisiting

for each step, we pop the smallest evelation from the heap and try to travel in all 4 directions

we track the maximum evelation encountered so far as that is the minimum water level to reach this cell

When we reach the bottom right of the grid, we return the maximum evelation encountered in this path as this is the minimum time required

Another Approach: 

We will be using dijkstas algorithm in a sense

We will use a min heap and bfs

The frontier will be held in the heap

The frontier is the neighbors we can visit of the current node

We add the coordinates and weight into the heap

we add to the heap the key as the value of each cell

This is what we will be minimizing in our heap

We will also have a set to keep track of visited cells

for the path, we add to the heap the maximum height of the path and the height that came before
*/