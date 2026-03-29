class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // we sort our intervals
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // we will keep track of our queries original indices
        // we will also sort the queries by value
        int[][] query = new int[queries.length][2];
        for(int i = 0; i < queries.length; i++){
            query[i][0] = queries[i];
            query[i][1] = i;
        }

        Arrays.sort(query, Comparator.comparingInt(a -> a[0]));

        // we will have a min heap to keep track of valid intervals and their respective lengths
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // we will also have our result array that we are returning at the end
        int[] result = new int[queries.length];

        // we also will have a pointer to help keep track which interval we are on 
        int i = 0;

        // we will iterate through the queries
        for (int[] q : query) {
            // we will iterate through the intervals
            // we ensure that our index is in bounds
            // we add the intervals to the heap where the start time is less than or equal to the query's value
            while(i < intervals.length && intervals[i][0] <= q[0]){
                // we then get the left and right values from this interval
                int left = intervals[i][0], right = intervals[i][1];
                // we will now add this to our heap
                // we will add the length of the interval and the right value to the heap
                minHeap.offer(new int[]{right - left + 1, right});
                // we update our index
                i++;
            }

            // we will now pop from our min heap
            // we will remove the intervals that the query doesn't belong to
            // if the right value is less than the query value, the query is not in this interval
            // we also ensure the heap is not empty as we don't want to pop from an empty heap
            while(!minHeap.isEmpty() &&  minHeap.peek()[1] < q[0]) minHeap.poll();

            // we now add the smallest lengths for each query in our result
            // we check if the min heap is not empty
            // if not empty the smallest value is the top of the heap
            // else we add -1
            result[q[1]] = !minHeap.isEmpty() ? minHeap.peek()[0] : -1;
        }

        return result;
    }
}

/*
We are given a 2D array of integers and an array of integers

We are asked to return an array of integers

Description:

We are given a 2D array of integers

They represent intervals

Where intervals[i] is deconstucted as [left_i, right_i]

This then represents the ith interval starting at left_i and ending at right_i (inclusive)

We are also given an array of integers

This represents query points

The result of query[j] is the length of the shortest interval i such that left_i <= queries[j] <= right_i

If no interval exists, the result of the query is -1

We want to return an array where array[j] is the result of query[j]

We note the length of an interval is right_i - left_i + 1

Example:

Input: intervals = [[1,3],[2,3],[3,7],[6,6]], queries = [2,3,1,7,6,8]

We see that queries[0] is 2

So we want to find the interval with the smallest length containing 2

that is intervals[1] so we add 2 to our output

We do this for queries[1] which is 3

The smallest length is found in interval[1] as it contains 3

We add 2 to out otput

We continue to do this

We find that queries[5] which is 8 is not in any intervals

So we add -1 to our output

We can then return [2,2,3,5,1,-1]

Note that the output is the size of the smallest interval length, not the interval itself

An Approach:

We want to find the shortest interval that contains each query point

So for each query 

We want to find the interval, [left, right], where left <= query <= right

Among all those intervals we want to return the one with the smallest length

length can be found as right - left + 1

if none exist, we return -1

We be using a sorting and heap approach

We will sort the intervals by start time

We will sort the queries with remembering their original indices

We will use a minheap to keep track of the candidate intervals

We will push intervals where start <= query

We will remove the intervals from the heap where end < query

As that means the intervals no longer contains the query

The top of the heap will give the shortest valid interval for that query

So

We will sort the intervals by start time

Pair each query with its original index and sort by query value

We will use a min heap to keep track of valid intervals, ordered by length

where each item in the heap is [length, end]

We iterate over the sorted queries

Add the intervals where start is less than or equalto the current query

remove from the heap where the interval's end is less than the query

if the heap is not empty, the top is the answer

Another Approach:

We will sort the intervals and queries

We will then scan the queries from left to right

We will also use a min heap to find the smallest interval length

We will iterate over all queries

We will sort the intervals by start time 

We will also iterate through the intervals via the smallest start time

For each query, we want to add all possible intervals it can belong to to the heap

The intervals the query can belong to is by comparing it to the start value of the interval

If the start value is greater than the query, the query cannot belong to this interval

So we will iterate over the intervals while the left value is less than or equal to the query

We add to our min heap

We calculate size by taking right - left + 1

So we add the length of the interval and the end time as a pair

As if the intervals have the same length, we would want to pop the interval with the earlier end time

We then after adding all valid intervals for this query, we check if the heap is not empty

If not empty we add the top as the answer to the array and else we add -1

As we sort the queries, we will need a hashmap to maintain the relative order which is needed for the result array

We pop intervals from our heap where the end/right value is less than the current query

We pop as we cannot consider these intervals
*/