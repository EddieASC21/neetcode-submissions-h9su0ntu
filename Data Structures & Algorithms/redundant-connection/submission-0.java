class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // we will create our parent array 
        int[] parent = new int[edges.length + 1];

        // we create our rank array
        int[] rank = new int[edges.length + 1];

        // we populate our parent and rank array
        for(int i = 0; i < edges.length + 1; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        // we go through every edge
        for(int[] edge: edges){
            // if we can't union, this is the edge creating the cycle
            if(!union(edge[0], edge[1], parent, rank)) return edge;
        }

        return new int[] {0, 0};
    }
    

    // helper function to find the root parent
    private int find(int node, int[] parent){
        // path compression
        // we update the parent node of the node until we find the node with the parent node as itself
        if(parent[node] != node) parent[node] = find(parent[node], parent);
        return parent[node];
    }

    // helper function to union the nodes
    private boolean union(int node1, int node2, int[] parent, int[] rank){
        // we find the root parents of the nodes
        int root1 = find(node1, parent), root2 = find(node2, parent);

        // we can't make an edge as they are already merged as have same root parent
        if(root1 == root2) return false;

        // we update the root parent based on the rank
        if(rank[root1] > rank[root2]){
            parent[root2] = root1;
            rank[root1] += rank[root2];
        }
        else{
            parent[root1] = root2;
            rank[root2] += rank[root1];
        }

        return true;
    }
}

/*
we are to return an array 

we are given a 2D array of integers 

Description:

We are given a connected undirected graph

we have n nodes

we note that the nodes are labeled 1 to n

When we first started off, no cycles and we had n - 1 edges

We now added one more edge to the graph

The edge has two different vertices from 1 to n and the edge was not previously in the graph

The graph is displayed by an array of edges of length n

edges[i] = [ai, bi] where this means that there is an edge between ai and bi

We want to return an edge that can be removed so that graph is connected and not have a cycle

we return the edge that appears last in the input edges if multiple answers

An approach:

We will be using union find

We will have an array

We will initialize each node as its own parent

For each edge

We will then try to union 2 nodes  

We note that if they have the same parent (the 2 nodes trying to union) that adding another edge will create a cycle 

We will return that edge

The reason why is that if only one more edge is added then only one cycle is formed, so there is only one to return

We will then try union find with path compression and union by rank

Where if our helper function union returns false, that is the edge we must return as this edge creates a cycle

Another approach:

We will use union find

If we add two nodes, adding an edge would make one component

With a connected component, adding a new edge, makes a cycle

the first edge that causes a cycle will be the one returned

we will iterate through every edge 

We have a parent and rank array

we reassign the parent of a node when making a valid union

the parent is reassigned for the smaller rank

we also then update the rank

we will always connect by parent
*/