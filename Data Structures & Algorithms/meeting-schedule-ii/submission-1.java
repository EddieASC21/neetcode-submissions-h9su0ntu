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
    public int minMeetingRooms(List<Interval> intervals) {
        // we create start and end time arrays
        int[] start = new int[intervals.size()], end = new int[intervals.size()];
        // we add all the start and end times to their respective arrays
        for (int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        // we sort the arrays 
        Arrays.sort(start);
        Arrays.sort(end);

        // we will have a result variable which will keep track of the maximum number of days we found needed
        // we will have two pointers that are initialized to 0 that point at the beginning of each array
        int result = 0, count = 0, p1 = 0, p2 = 0;

        // we iterate while our start time pointer is in bound
        while(p1 < start.length){
            // we check if conflict
            // we check if the start time is less than the end time
            // if so we have a conflict
            // we increment the count
            // we update the pointer of the start array
            // we will also update the maximum value found of count
            if(start[p1] < end[p2]){
                count++;
                p1++;
                result = Math.max(result, count);
            }
            // else they are equal/no conflict
            // we update the pointer of the end array
            // we decrement count
            else{
                p2++;
                count--;
            }
        }

        // we return the result as that is the maximum value found
        return result;
    }
}

/*
We are given a list of interval objects

We are given an interval class where we can access two integers

We want to return an integer

Description:

We are given an array of meeting time interval objects

These objects consist of start and end times

We want to find the minimum number of days we need to schedule all meetings with no conflict

We note that, for example, (0, 8) and (8, 10) is not considered an conflict/overlap at 8

Input: intervals = [(0,40),(5,10),(15,20)]

So what we will do is note that we have only one conflict

So that means we need only need minimum 2 days

An Approach:

We can use a min heap to keep track of the end times 

We will sort the intervals by start time

We will use the min heap to keep track of the earliest end time of the current meetings

for each meeting

We will check if the start of the current meeting is greater than or equal to the peek of the heap, we can reuse the same day

Then we would pop from the heap and add the end time of the current meeting

Else we would increment the amount of days and add the end time of the current meeting to the heap

We return the size of the heap as that is the minimum number of days needed

Another Approach:

We will sort the intervals

We will add the start times in an array in sorted order

We will also do this with the end times

We will have two pointers pointing at the two arrays

We will pick the minimum value

If the minimum value we pick is in the start array, we increment the count of days

If the pointers have the same value, we increment the pointer in the end array

If we increment the pointer in the end array, we decrement the count of days

As we do this we keep track the maximum value our count ever was

We end once we have processed all values in the start time array

We return the maximum count value
*/