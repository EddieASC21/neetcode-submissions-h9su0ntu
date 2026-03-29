class Solution {
    public int[][] merge(int[][] intervals) {
        // we will sort the intervals by start time 
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        // we add the first interval to our result to compare
        result.add(intervals[0]);

        // we will now iterate over each interval starting from the second interval
        for(int i = 1; i < intervals.length; i++){
            // overlap
            // we check if the previous interval end time is greater than or equal to the start time of the current interval
            // if so there is overlap
            if(result.get(result.size() - 1)[1] >= intervals[i][0]){
                // we merge
                // we will update the previous intervals end time to be the maximum of the previous and current interval end times
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], intervals[i][1]);
            }
            // no overlap
            // we just add to our list
            else{
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}

/*
We are given a 2D array of integers

We want to return a 2D array of integers

Description:

We are given an array of intervals

Where intervals[i] = [start_i, end_i]

We want to merge all overlapping intervals

We want to return an array of the non overlapping intervals 

We can return the answer in any order

We note that the intervals are non overlapping if they have no common point

For example [1, 2] and [3, 4] are non overlapping

But [1, 2] and [2, 3] are overlapping

Example:

Input: intervals = [[1,3],[1,5],[6,7]]

We will compare the current interval with the next one

We check if they have a common point and update if they do

[1, 3] and [1, 5] have a common point and that is 1 and 2 and 3

So we update the interval to be the minimum of the array[0] and maximum of array[1]

So now we have the interval as [1, 5]

We now carry the current interval as [1, 5] and compare it to [6, 7]

There is no common point so we add it to our list 

We return the output as [[1, 5], [6, 7]]

An Approach:

We will be doing a sorting and greedy approach

We will sort the intervals by start times

This will help with processing the intervals from left to right helping us detect overlaps

We will initialize a list with our first interval

We will then iterate over each interval starting from the second one

We will compare the start of the current interval's start time with the end time of the last merged interval in our result list

If these two intervals overlap, we will merge them by updating the end time of the last interval in the array

We will update the end time to the maximum of the two end times

If there is no overlap, we add the current interval to our result list

We will then at the end return the result list

By sorting the intervals by start times, any overlap will happen at consecutive intervals 

That is why we compare the current interval with the last one in the result list

Another Approach:

We will sort by start times

We then check if the current interval overlaps with the previous interval

If so we can merge it into one interval
*/