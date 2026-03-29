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
        // check if we have no meetings so we can return 0
        if(intervals == null || intervals.isEmpty()) return 0;

        // we sort by start times and if they are equal we then sort by end times
        Collections.sort(intervals, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);

        // create a minheap to help keep track of when meetings end
        // we add the earliest end time to the top of the heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // we go over every time interval
        for(Interval interval : intervals){
            // if the next meeting starts after or exactly when the first meeting ends, we can remove the earliest meeting from the heap as we can use same day
            if(!minHeap.isEmpty() && interval.start >= minHeap.peek()) minHeap.poll();

            // we add the current meetings end time to the heap
            minHeap.add(interval.end);
        }

        // size of heap represents the minimum number of days
        return minHeap.size();

    }

}
