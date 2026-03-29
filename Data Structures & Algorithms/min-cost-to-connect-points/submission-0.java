class Solution {
    public int minCostConnectPoints(int[][] points) {
        // we get the number points we have 
        int n = points.length;
        // we create the adjacency list
        // the key is the node
        // the value is a list of points where each point will have the cost and the neighbor
        Map<Integer, List<int[]>> map = new HashMap<>();

        // we want to compare the nodes against each other
        for(int i = 0; i < n; i++){
            // we get the coordinates for the point at i
            int x1 = points[i][0], y1 = points[i][1];
            for(int j = i + 1; j < n; j++){
                // we get the coordinates for the point at j
                int x2 = points[j][0], y2 = points[j][1];

                // we now take the manhattan distance between the two points
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                
                // we append the cost and dist with the node itself
                map.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{dist, j});
                // we add the reverse of this as this is an undirected edge 
                map.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{dist, i});
            }
        }

        int cost = 0;

        // we have a set to keep track of visited nodes
        Set<Integer> set = new HashSet<>();

        // we will have a min heap
        // the min heap will be minimizing by cost
        // we will intialize the min heap with the first node with a cost of 0
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, 0});

        // we continue while the size of the visited set is less than the number of points
        while(set.size() < n){
            // we now pop from the heap
            // when we popped, we are returned the cost of the edge and the neighboring node
            int[] node = minHeap.poll();

            // we note we are adding duplicates to the minheap
            // so if it is in our visited set, we continue
            if(set.contains(node[1])) continue;

            // if not visited, we add the cost to our result
            cost += node[0];
            // we also add it to our visited set to ensure it's not processed again
            set.add(node[1]);

            // we now go through every neighbor of this node
            for(int[] neighbor : map.getOrDefault(node[1], Collections.emptyList())){
                // we check of the neighor is not in our visited set to add to our heap
                // if not we continue
                if(!set.contains(neighbor[1])) minHeap.offer(new int[]{neighbor[0], neighbor[1]});
            }
        }

        return cost;
    }
}

/*
We are given a 2D array of integers

We are asked to return an integer

Description:

We are given a 2-D integer array points 

Where we have points[i] as [xi, yi]

Each points[i] is the distnct point on a 2-D plane

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between two points

The manhattan distance can be seen as |xi - xj| + |yi - yj|

We want to return the minimum cost to connect all points together 

Where there is only one path between each pair of points

Example:

Input: points = [[0,0],[2,2],[3,3],[2,4],[4,2]]

We can connect point [0, 0] to all points and we would minimum cost would be to [2, 2]

As [0, 0] and [2, 2] are connected with a cost 4

We now can try to connect [0, 0] to something else or [2, 2] to something else

We see that the cheapest would be to connect [2, 2] to all the other points

We can choose either and we will choose to connect to [2, 4]

So now we have connected three points at cost of 6

We can now choose again to connect any point to the remaining to unmarked

We see that we can connect [2, 2] and [2, 4] to [3, 3] for cost of 2

So we can choose any as we note that order doesn't matter just cost

We are not at a cost at 8

We then have to connect it all to [4, 2]

We see that [2, 2] and [3, 3] can both connect for a cost of 2

As said ordering doesn't matter so we ultimately end up at a cost at 10

This is the minimum cost needed to connect all points so we return 10

An Approach:

We will be looking at this problem as finding the minimum spanning tree over a graph

We will treat each point on the 2-D plane as a node

The manhattan distance will be the cost to connect two nodes

We will use prims algorithm

So to begin

We want to keep track of the number of total points

Have a visited array which we initialize as false for all points

Have minimum distance array which we set as infinity for all points expect for the point at index 0 as that is 0

We will have a variable to keep track of total cost

We will repeat the following steps n times where n is the number of total points

We find the unvisited node, node u, with the smallest value at the index u in the minimum distance array

We will add that cost to our total cost

We will mark u as visited in our visited array

Then for every unvisited node, node v, we update minimum distance at index v as the minimum of the minimum distance value at index v or the manhattan distance between nodes v and u

We then return the total cost

Another Approach:

We will create an adjacency list to create the edges

We will then use Prims algorithm

We will use a min heap

So for Prims

We will choose any start node in the graph

We will perform BFS on that node

Where we will visit nodes and as we visit nodes, we will have two data structures

A visited data structure to not add the same node twice to aviod cycles

A min heap to keep track of our frontier of our bfs

The frontier being every possible node that can be added from the node we are visiting

The possible nodes will be in the frontier with their index and the weight of their edge

Where the weight of the edge is the key for the min heap as we want to connect the nodes with the minimal possible cost

then from the next node, we can add and readd the previous candidates to the frontier as they may possible have a different connection weight from the new node that is smaller from the previous node

We will use a set to keep track of visited nodes

We stop the algorthim once the size of our set is equal to the number of the nodes

The cost to add the starting node is 0

We will also keep track of our cost

From each step, we pop from the the heap and it's neighbor to the frontier

We will also have an adjacency list to have a valid graph to traverse 

When we pop a node from frontier, we add it to the visited set and its weight to our minimum cost

We will add the same nodes as many possible frontiers in our heap

Once the size of our set is equal to the number of the nodes in the graph, we return our minimum cost
*/