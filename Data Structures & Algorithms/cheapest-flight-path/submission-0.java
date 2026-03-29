class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // we create a prices array to keep track of the minimum cost to reach node at each iteration
        int[] prices = new int[n];
        // we initialize all values in prices to be infinity to make easy comparisons
        Arrays.fill(prices, Integer.MAX_VALUE);
        // expect for the src node as that is zero to reach
        prices[src] = 0;

        // we will iterate through the graph k + 1 times
        for(int i = 0; i < k + 1; i++){
            // we need a temporary prices array as this will keep track of our updates per iteration
            int[] temp = Arrays.copyOf(prices, prices.length);
            // we iterate through every edge
            for(int[] flight : flights){
                // if our current soure node price is infinity, that means we can't reach it
                // so we would skip these edges
                if(prices[flight[0]] == Integer.MAX_VALUE) continue;

                // if we found a new shortest path to reach our current source node, we update it in our temp array
                if(prices[flight[0]] + flight[2] < temp[flight[1]]) temp[flight[1]] =  prices[flight[0]] + flight[2];
            }

            // we now reassign our prices array to our temp array after each iteration
            prices = temp;
        }

        // we return the value of found at the array at the dst index if not infinity else we return -1
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}

/*
We are given 4 integers and a 2D array of integers

We are asked to return an integer

Description:

We are given n airpots

The airports are labeled from 0 to n - 1

Some of these airports are connected by flights

We are given an array named flights

Where flights[i] is [from_i, to_i, price_i]

This represents a one way flight from airport from_i to airpot to_i with a cost of price_i

We may assume that there are no duplicate flights

We can also assume there are no flights from an airport to itself

We are also given three integers:

src - the starting airport

dst - the destination airport

We note that src is not equal to dst

k - the maximum number of stops we can make not including src and dst as stops

We want to return the cheapest proce from src to dst with at most k stops

If this is impossible, we return -1

Example:

Input: n = 4, flights = [[0,1,200],[1,2,100],[1,3,300],[2,3,100]], src = 0, dst = 3, k = 1

So we are starting from node 0, we must travel to node 3

We note that we can only make 1 stop from node 0 to node 3

So we see that the only flight from node 0 is flights[0] 

So we then stop at node 1 with a cost of 200

We now note since we have tajen 1 stop, we must go from node 1 to node 3

The only option is flights[2] where we can go from node 1 to node 3 with a cost of 300

So our total cost is 500 which is what we return 

An Approach:

We note that we are limited to k stops, so we will at most have k + 1 edges

We will keep track of 3 things: cost, nodes, and stops

We note that if we exceed k stops, we abandon this path

We will use BFS and a priority queue

We will have a min heap that will store the cost so far, the current city, and the number of stops

So we will build an adjacency list from the flights array

We will use a min heap to expand the cheapest route

We will have a map to keep track of the cheapest cost available to reach this node and the number of stops needed

Then for each node, we will add its neighbors to the queue with the updated cost and number of stops

We stop we reach the dst node within the given number of stops

Another Approach:

We will use Bellman-Ford Algorithm

It will be similar to BFS

We will be looking at all edges
*/