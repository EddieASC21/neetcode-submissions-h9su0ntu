class Solution {
    public int countComponents(int n, int[][] edges) {
        // number of connected components we start out with is n
        int result = n;

        // we have a parent array
        // each node is the parent of itself to begin
        int[] parent = new int[n];

        // we have a rank array
        // each component will have a rank of 1 initially
        int[] rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        // we will now go through every edge 
        // we will union the edges
        for(int[] edge : edges){
            // every time we create a successful union, we decrement the number of components we have
            if(union(edge[0], edge[1], parent, rank)) result--;
        }

        return result;
    }

    // helper function to find root parent
    private int find(int node, int[] parent){
        int rootParent = node;

        // we stop searching once we get to a node that its a parent to itself
        while(rootParent != parent[rootParent]){
            // we set the parent of our node to its grandparent if it exists
            // imagine going up the tree to find the root
            parent[rootParent] = parent[parent[rootParent]];
            // we update the current pointer to be its parent
            rootParent = parent[rootParent];
        }

        return rootParent;
    }

    // helper function to carry out the union of nodes
    private boolean union(int node1, int node2, int[] parent, int[] rank){
        // we must find the root parents of each node
        int rootParent1 = find(node1, parent), rootParent2 = find(node2, parent);

        // if both nodes have the same root parent we return
        // false shows we didn't perform a union
        if(rootParent1 == rootParent2) return false;

        // we perform the union based on rank
        // the smaller rank has to now merge
        // the root parent for both these nodes would be of the greater rank
        if(rank[rootParent2] > rank[rootParent1]){
            // the parent of the smaller rank is updated
            parent[rootParent1] = rootParent2;
            // as we just made a union, we update the rank
            rank[rootParent2] += rank[rootParent1];
        }
        else{
            parent[rootParent2] = rootParent1;
            rank[rootParent1] += rank[rootParent2];
        }

        return true;
    } 
}

/*
We are to return an integer

We are given an integer and a 2D array of integers

Description:

We are given n nodes

We have a 2D array of edges

The edges are set up as edges[i] = [a, b]

This means that there is an edge between node a and node b (going both sides)

The nodes are indexed from 0 to n - 1

We must return the total number of connected components

Description:

When we run a traversal algorithm between two components, we group the nodes that are connected

We then count how many different number of groups we have

What we will do is build 

We will use the edges to build an adjacency list

We also use a visited set to keep track of the nodes we have visited

For every node that has not been visited/not in the set, we run our traversal algorithm on it and increment component count

we then return the count

Another description:

We will use union find

We will have 2 arrays

A parent array

this array will hold the index of the nodes as a value

this mean that every node is a parent to itself

union find is a forest of trees

When we make a connection, we decrement the number of connected components (from the integer given)

We will maintain the rank of every component, keep track of the size

We update the parent's rank as we merge

this will help with merging the smaller connected component with a bigger one (higher rank)

We are minimizing the size of the tree 

To merge

We get the root parent of each component 

this helps check if the components are connected or not

We will always add to the root parent

this helps minimize the rank of the tree

We update the parent array to show which each index root parent is

Also we return immediatly if we see have the same parent
*/