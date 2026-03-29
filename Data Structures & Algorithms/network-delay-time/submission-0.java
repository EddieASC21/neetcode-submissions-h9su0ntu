class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // we create an adjacency list from the 2d array given to help denote the connected graph
        Map<Integer, List<int[]>> map = new HashMap<>();

        // we go through every edge of each node
        // we will get the list of all of its neighbors
        // the key is the source node
        // the value is the target node and its weight
        for(int[] time : times) map.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});

        // we will now create the min heap where we will compare by time 
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // we will initialize our queue with k, the source node with a time of zero
        minHeap.offer(new int[]{0, k});
        
        // we will also have a set
        // this set will keep track of the visited nodes
        // this aviods cycles
        Set<Integer> set = new HashSet<>();

        int result = 0;

        // we continue this algorithm while this minHeap is non empty
        while(!minHeap.isEmpty()){
            // we pop from the heap
            int[] node = minHeap.poll();
            // with array deconstructing 
            // the weight is the first value
            // the node is the second value
            int time = node[0], position = node[1];

            // we note if we have visited this position already to avoid a cycle
            // if the position is in the set, we continue to the next iteration of the loop
            if(set.contains(position)) continue;

            // if not, we add it now to the set to aviod a cycle
            set.add(position);

            // we update our result to the max of itself and the new weight found
            result = Math.max(result, time);

            // we ensure that this node has neighbors to visit
            if (map.containsKey(position)){
                // we now will visit the neighbors of this node
                for(int[] neighbor : map.get(position)){
                    // for all of the neighbors not visited, we add it to the min heap
                    // we add the updated weight 
                    if(!set.contains(neighbor[0])) minHeap.offer(new int[]{time + neighbor[1], neighbor[0]});
                }
            }
        }

        // we return our result if it is possible
        // it is possible if the size of our set is equal to n
        // if it is not, we return -1
        return set.size() == n ? result : -1; 
    }
}

/*
We are given a 2D array of integers

We are also given two integers

We are asked to return an integer

Description:

We are given a network that consists of n directed nodes

These directed nodes are labeled 1 to n

We are also given times

It is given as a list of directed edges where times[i] = {ui, vi, ti}

where:

ui is the source node

vi is the target node

ti is the time it takes to travel from the source to the target node

We note ui and vi is an integer from 1 to n 

Also ti is greater than or equal to 0 as we can't have negative time

We are given an integer k

K represents the node that we will send a signal from 

We want to return the minimum time needed for all n nodes to recieve the signal

If this is not possible for all the nodes to recieve the signal, we return -1

Example;

Input: times = [[1,2,1],[2,3,1],[1,4,4],[3,4,1]], n = 4, k = 1

The signal node is 1 

This means we start from node 1

From node 1, we can go to node 2 or node 4

We can go from node 1 to 2 with cost of 1

or

we can go from node 1 to 4 with cost of 4

It is cheaper to go to node 2

We go to node 2 with a new cost of 1

From node 2, we can only go to node 3

We go to code 3 with a new cost of 2

From node 3, we can only go to node 4

From node 4, we arrive with a cost of 3

We have visited all nodes and return the minimum price of 3

An Approach:

We will use Dijkstra's algorithm

We will first build a graph using an adjacency list

We will use a min heap to explore the shortest path of each node

We will have a hashmap to record the shortest time to reach each node

We will then check:

if all nodes have been visited, size of the map is equal to n, return the maximum time among all shortest times

If not all nodes have been reached, we return -1

Another Approach:

We will use a min heap to decide which node to travel to next with a the combination of bfs to dictate how we travel by layers

We will use a min heap that takes in the path time and node

We will compare by the time, taking the smaller time

To our min heap, we begin with adding our source node with time 0

When we pop from the min heap, we get the neighbors of the node popped to take the shorter path by adding to the min heap

As we add to the heap, when we add the time, we add the total time not just the weight given

When we reach all nodes, we return the maximum time found

If we could not, we return -1
*/