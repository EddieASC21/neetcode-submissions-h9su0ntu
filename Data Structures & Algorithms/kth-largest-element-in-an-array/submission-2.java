class Solution {
    public int findKthLargest(int[] nums, int k) {
        // we initialize our minHeap to keep track of the kth largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // we now iterate over all numbers in the nums array
        for(int num : nums){
            // we add the current element to the heap
            minHeap.offer(num);

            // if the heap is greater than k, then we remove the smallest from the heap to keep track of the kth largest elements
            if(minHeap.size() > k) minHeap.poll();
        } 

        // we now return the root of the heap as that is the kth largest element as in a heap we are known to have k - 1 values larger than the root, making the root the kth largest element in the array
        return minHeap.peek();
    }
}