class Solution {
    public int[][] merge(int[][] intervals) {
        // check if we have just one interval which is what we will return
        if(intervals.length <= 1) return intervals;

        // we sort the intervals by start time
        // we want the earliest start time at the front of the array
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // we create a list to hold our merged intervals
        List<int[]> merged = new LinkedList<>();

        // iterate over the sorted intervals and see if we need to merge
        for(int[] interval : intervals){
            // if list is empty or no overlap then no need to merge and will just add interval to list
            if(merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) merged.add(interval);
            // if there is overlap we merge the two intervals and take the max of the two intervals end times
            else merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
        }

        // we now convert to 2D array and return
        return merged.toArray(new int[merged.size()][]);
    }
}