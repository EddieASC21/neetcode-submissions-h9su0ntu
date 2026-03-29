/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // we sort the intervals by start time
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        // we will now iterate over all the intervals
        // we start at index 1 as the current interval
        // this will set index 0 as the previous interval
        for(int i = 1; i < intervals.size(); i++){
            // we check if there is overlap
            // overlap is found if the end of the previous interval is greater than that of the start of the current interval
            if(intervals.get(i - 1).end > intervals.get(i).start) return false;
        }

        // no overlap ever found
        return true;
    }
}

/*
We are given a list of intervals

We have an interval class that we can access the start and end time

We are asked to return a boolean

Description:

We are given an array of meeting time interval objects

These objects consist of start and end times

We want to know if we can add all meetings in our schedule with no conflict

Example:

Input: intervals = [(0,30),(5,10),(15,20)]

As we note we will have 2 conflicts

the first two intervals overlap and the first and last interval overlap

As intervals overlap, we cannot make it to all meetings

So we return false

An Approach:

We will use a greedy and sorting approach

We sort the intervals

We will sort all the intervals by start time

So we check for overlap by comparing the meeting with the one before it

We compare the meetings

So we iterate over the new sorted intervals

Where we compare the current meetings start time with the previous ones end time to check for overlap

if the current start is less than the previous end, there is a conflict/overlap and so we return false

if no conflict is found, we return true


Another Approach:

We will sort the intervals by start time

We will check against the start time of the current interval and the end of the previous interval to check for overlap

If we find overlap, we return false else true if no overlap found
*/