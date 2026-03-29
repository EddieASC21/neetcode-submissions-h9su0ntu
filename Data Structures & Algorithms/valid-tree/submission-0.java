class Solution {
    public boolean validTree(int n, int[][] edges) {
        // we check if we have no nodes
        // we note an empty graph counts as a tree
        if(n == 0) return true;

        // we use a set to keep track of visited nodes
        Set<Integer> set = new HashSet<>();

        // we create our adjacecny list
        // we create this using hashmap
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) map.put(i, new ArrayList<>());

        // we populate our adjacency list with its neighbors
        for(int[] neighbor : edges){
            // note this is an undirected graph
            // so we add both sides of direction
            map.get(neighbor[0]).add(neighbor[1]);
            map.get(neighbor[1]).add(neighbor[0]);
        }
        
        // we pass in the current node as 0
        // we pass in previous node as -1 as no node is -1 so placeholder in a sense
        // we ensure that there is no cycles and our visited set size is equal to the number of nodes to show all nodes can be visited
        return (helper(map, set, 0, -1)) && n == set.size();
    }

    // recursive helper function to carry out dfs 
    private boolean helper(Map<Integer, List<Integer>> map, Set<Integer> set, int node, int prev){
        // base case

        // if our node is in our set, we have found a cycle
        if(set.contains(node)) return false;

        set.add(node);

        // we will go through the neighbors of our current node
        for(int neighbor : map.get(node)){
            // we check if our neighbor is equal to the previous node
            // if so we skip over it
            if(neighbor == prev) continue;

            // recursive case

            // the neighbor becomes the new current node
            // our node now becomes our previous node
            // we return false to show a loop was detected
            if(!helper(map, set, neighbor, node)) return false;
        }

        return true;
    }
}

/*
We are to return a boolean

we are given an int and a 2D array of integers

Description:

We have n nodes, the integer given to us

The nodes are labeled from 0 to n - 1

We have a list of undirected edges (each edge is a pair of nodes) which is given to us as the 2D array of integers

We will provide a function to check if these edges can make a valid tree

An approach:

To note that we can create a valid tree we must ensure these two properties

We are able to reach any node starting from any node

That we must not contain any cycles in the tree

With n nodes

this means we must have n - 1 edges

If we have less edges than n - 1 that means that all nodes are not connected and so breaks the first property

If we more edges than n - 1 that means we have a cycle meaning that we break the second property

So what we can do is check the number of edges if it is equal to n - 1

We would iterate over the tree using dfs or bfs

We must also see if we can check all nodes with the traversing algorithm

Another Approach:

We will use dfs to traverse the tree

we will see if the number of nodes we visited nodes is equal to number of nodes given

We also will keep track of a visited set to ensure we don't have a cycle

To ensure we don't have false positive (going from parent to child back to parent, false cycle), we will keep track of the previous node (parent node)

We will skip its previous node when we are traversing back

base case:

when we reach a leaf node, we return true as no loop found

the previous value for the root will be by default to -1 as all nodes are 0 or greater

at the end we check to see the size of our visited set and number of nodes to ensure our graph is connected

with the set, we detect loops/cycles and return false if one is found
*/
