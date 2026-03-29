class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // we will sort the interval by the end value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        // we set the previous end as the first intervals end
        int count = 0, prevEnd = intervals[0][1];

        // we iterate over the intervals starting from the second interval
        for(int i = 1; i < intervals.length; i++){
            // they are not overlapping if the start time of the current interval is greater than or equal to the previous end
            // if they are not overlapping, we will update our previous end from the current interval
            if(intervals[i][0] >= prevEnd) prevEnd = intervals[i][1];
            // if they overlap, we update the count as we need to remove an interval
            else count++;
        }

        return count;
    }
}

/*
We are given a 2D array of integers

We are asked to return an integer

Description:

We are given an array of intervals

Where intervals[i] = [start_i, end_i]

We want to return the minimum number of intervals we need to remove to have all non-overlapping intervals

We note that intervals are non-overlapping even if they have a common point

As for example: [1, 3] and [2, 4] are overlapping

Yet [1, 2] and [2, 3] are non-overlapping

Example:

Input: intervals = [[1,2],[2,4],[1,4]]

We will note that we will add our first interval to our result as we have no overlapping untervals

We then can add the next interval as although they have a common point, they do not overlap

The last interval overlaps with both intervals and so we can remove this one

We then return 1 as we only need to remove the last interval to have all non overlapping intervals

An Approach:

We will use a greedy approach

We will be greedy based on end time

So to keep as many intervals as possible, we want to keep the ones with the earliest end time

The reason is that this will allow us more room for future intervals

So we will sort the intervals by end time

We will keep track of two intervals

One is the count of intervals to remove and the other to keep track the end of the last interval

We will then iterate over all the intervals

if the start of the current interval is greater than or equal to the end of the last interval, then there is no overlap

We would then update our previous end

If it is overlapping, we will increment the count of intervals to remove

Another Approach:

We want to sort by end times

If having a choice of which interval to remove, we remove the interval that ends last

With also keeping track of the previous end
*/