class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // we create our adjacency list
        // our key is the source airport
        // the value is the airports it can visited to in sorted order
        // we can maintain sorted order by using a min heap instead of a list
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        
        for (List<String> ticket : tickets) map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        
        // we will use a linked list to store our result as that will help with adding to the front
        LinkedList<String> result = new LinkedList<>();

        // our starting pointer will always be JFK so this where we start the recursive function
        helper("JFK", map, result);

        return result;
    }

    // recursive helper function to carry out dfs
    private void helper(String src, Map<String, PriorityQueue<String>> map, LinkedList<String> result){
        // we want to visit all of the neighbors of our source node
        // we continue as long as their are neighbors to visit and this node exits in our graph
        // we visit the neighbors in lexical order and remove it from the grpah by popping from the queue
        while(map.containsKey(src) && !map.get(src).isEmpty()) helper(map.get(src).poll(), map, result);

        // after visiting the neighbors and removing the airport, we add it as the head of our list
        result.addFirst(src);
    }
}

/*
We are given a list of list of integers

We are asked to return a list of strings

Description:

We are given a list of flight tickets

Where tickets[i] is [from_i, to_i]

This represent the source airport and the destination airport

Each from_i to to_i consists of three uppercase English letters

We want to reconstruct the itinerary in order and return it

All the tickets belong to someone who originally departed from "JFK"

Our objective is to reconstruct the flight path that this person took

We are safe to assume that each ticket was used exactly once

If there are multiple valid flight paths, we return the lexicographically smallest one

For example:

The itinerary ["JFK", "SEA"] has smaller lexical order than ["JFK", "SFO"]

We want to assume that all tickets from at least one valid flight path

Example:

Input: tickets = [["BUF","HOU"],["HOU","SEA"],["JFK","BUF"]]

We start from 

JFK as always

From JFK we can go to BUF

From BUF we can go to HOU

From HOU we can go to SEA

That is the end

So we return ["JFK" "BUF" "HOU" "SEA"]

An Approach:

We will use graph traversal and backtracking

We will use Heirholzer's algorithm for Eulerian paths

We ensure we take the lexicographically smallest path when we have multiple path options

We will think of the problem like this:

We are given a directed graph where each ticket is an edge

We want to find a path where:

starts at "JFK"

every edge is used once

return the lexicographically smallest path among all of them

This is similar to finding the Eulerian path as every edge is used once

lexicographical ordering is needed, so we need to visit the next destination in sorted order

since every edge we use once, we must mark edges visited as we traverse

So

We will build a graph

We will have an adjacency list

The key is a string and the value is a minHeap of strings

The minHeap ensures that the lexicographically smallest neighbor is always visited first

We will use DFS

We will start the DFS from JFK

At each node, while there are neighbors, we will recursively visit them

We will add the node at the front of the result list after visiting all its neighbors

We will return the result

the itinerary will be constructed in reverse so we will return it in reverse

Another Approach:

We can run dfs starting from JFK

We will create an adjacency list to traverse of the graph

our keys will be our source airports

the values are the airports we can go to 

We want those in sorted order to make it easier to travel lexically 

We now run dfs after the values are sorted

We will travel to the airport that come first after jfk

We know we are done with the length of our result list is equal to our ticket length + 1
*/
