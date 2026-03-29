/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // we use a hashmap to map our original node to its clone
        Map<Node, Node> map = new HashMap<>();

        // if the node is null then we have to return null else we can run our helper function
        return node != null ? helper(map, node) : null; 
    }

    // recursive helper function to carry out dfs
    private Node helper(Map<Node, Node> map, Node node){
        // base case

        // we check if our node is in our map
        // if it is, then that means a clone exists
        // if we have a clone already, we return the clone
        if(map.containsKey(node)) return map.get(node);

        // we will create a clone of our node
        // the value of the clone is the value of the original node
        Node clone = new Node(node.val, new ArrayList<>());
        // we add the clone to our map
        map.put(node, clone);

        // we now want to make copy of every neighbor of the original node
        // we will go through every neighbor
        // we will run dfs on every neighbor
        // as our helper function returns the clone node
        // we will call the clone neighbors attribute and add to it the node the helper function returns
        for(Node neighbor : node.neighbors) clone.neighbors.add(helper(map, neighbor));

        return clone;
    }
}

/*
We are to retunr a node representing of our cloned graph

We are given a node to help access the graph

We note the nodes attributes 

The node has a value and neighbors

so the node has a value represented as an integer

the node also has neighbor, undirected connected components, represented as an array list with all the neighbor nodes

Also given examples of how the attributes are used

The description:

We are given a node in a connected undirected graph where we want to return a copy of this graph

We note that each node in our graph has an integer value and a list of its neighbors

The graph is represented as an adjacency list

An adjacency list is a mapping of nodes to a list of nodes

Each list of nodes is to represent the neighbors of a node in a graph

We note that the nodes value range from 1 to n and we have n nodes in the graph

The index of each node is the same as the node's value as 1-indexed

The input node will always be the first node in the graph and has a value of 1

Example:

adjList = [[2],[1,3],[2]]

output: [[2],[1,3],[2]]

The reason for this answer:

We have 3 nodes in the graph

Node 1 has a value of 1 and its neighbor is 2

Node 2 has a value 2 and its neighors are 1 and 3

Node 3 has a value of 3 and its neighbors is 2

An approach:

We will have a map such that we map the original node to its clone

We will be using dfs

Where our base case would be if a node is null, we return null

When making clones of nodes, we check if we have already done so by checking against the map

if the clone already exists in the map, we return the clone

if not we then clone the node

We then add the clone to the map

We then recursively go through each neighbor

we add this to the clone.neighbors

Another approach:

We will use a hashmap and dfs

We will map the old node to the new node, our clone nodes

we start at node 1

we will create a copy of the node as it doesn't exist as a key in our map

We make a copy of node 1 and map node 1 to clone node 1

now recursively go to its neighbor

We now clone from the neighbor

We clone the neighbor and add it to the hashmap

Now for the neighbor, one of the neighbors is node 1

So we go to node 1 and try to clone it but note its already in our map and have cloned it

So now we note that we can add the clone to the neighbor list of the clone
*/