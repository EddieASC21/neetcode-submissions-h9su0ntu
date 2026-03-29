class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // we create a minHeap that will store the points based on their euclidean
        // distance (squared since won't use square root) from the origin
        // this minHeap will help keep track of the closest points to the origin
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        for(int[] point : points) {
            // we now calculate the distance of each point from the origin
            int distance = point[0] * point[0] + point[1] * point[1];

            // we now add each point into the minHeap where we add the point as an array
            // where the first element in the array is the points euclidean distance squared
            // from the origin, the second element being its x coordinate (point[0]), and
            // the third element being the y coordinate (point[1])
            minHeap.offer(new int[] {distance, point[0], point[1]});
        }

        // we now create a result array to hold k closest points
        int[][] result = new int[k][2];

        // we will now take the first k elements from our minHeap to add to our array
        for(int i = 0; i < k; i++) {
            int[] point = minHeap.poll();

            // for the k elements removed from the minHeap, we would then add their
            // coordinates into the result array disregarding the distance
            result[i] = new int[]{point[1], point[2]};
        }

        return result;
    }
}