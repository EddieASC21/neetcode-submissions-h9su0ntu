class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> updated = new ArrayList<>();
        boolean inserted = false;

        // we iterate through every interval
        for(int i = 0; i < intervals.length; i++){
            // if the new interval goes before the current interval
            if(newInterval[1] < intervals[i][0]){
                if (!inserted) {
                    updated.add(newInterval);
                    inserted = true;
                }
                updated.add(intervals[i]);
            }
            // the new interval goes after the current interval
            else if(newInterval[0] > intervals[i][1]) updated.add(intervals[i]);
            // we have overlap
            else{
                // we will update the new interval
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }

        if (!inserted) updated.add(newInterval);
        
        return updated.toArray(new int[updated.size()][]);
    }
}

/*
We are given a 2D array of integers and an array of integers

We are to return a 2D array of integers

Description:

We are given an array of non-overlapping intervals

We note that within the array intervals, intervals[i] = [start_i, end_i]

This represents the start and end time of the ith interval

These intervals are sorted in ascending order by start_i

We are given another interval, newInterval = [start, end]

We want to insert this new iterval into the original interval array

We want to maintain the relative order in respect to the manner it is ascending order by start_i

Yet also ensuring that the interval array does not have any overlapping intervals

We may merge overlapping intervals if needed

We want to return our interval array after adding the new interval

Note; Intervals are non overlapping if they have no common point

So [1, 2] and [3, 4] are not overlapping but [1, 2] and [2, 3] is

Example:

Input: intervals = [[1,3],[4,6]], newInterval = [2,5]

We note that the new interval has a common point with [1, 3]

Its start point is before the end point 

So we can merge it to [1, 5]

But we note that [1, 5] and [4, 6] have common points so we merge that 

That being said the answer is [[1, 6]]

An Approach:

We will use a linear scan as we note that the interval array is already sorted by start time and non overlapping

We will initialize a result list to hold the merged intervals

We will iterate through each interval 

If the current interval ends before the new interval starts, it will come before and we add it to our result

If the current interval starts after the new interval ends, it comes after and so we add it to our result

Now if there is a common point between the two intervals, we will merge them and add the merged version

If at the end of the loop, we haven't added the interval, we add it to the result to the end

Another Approach

To merge two intervals if they overlap, the start will be the minimum of the two starts and the end will be the maximum of the two ends
*/