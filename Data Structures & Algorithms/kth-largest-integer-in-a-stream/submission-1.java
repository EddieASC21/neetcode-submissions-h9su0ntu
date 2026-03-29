class KthLargest {

    // we create a global variable of out minheap and k that will be part of our class 
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        // we now reference our global variables
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        // we start to construct our heap
        // we add to the heap as long as the size of heap is less than the size of k, if greater than the size of k, we must pop out the smallest element in the minHeap
        for(int num : nums){
            minHeap.offer(num);
            if(minHeap.size() > k) minHeap.poll();
        }
    }
    
    public int add(int val) {
        // we now add the value to the minHeap
        minHeap.add(val);
        // we now check if when we add, that the minHeap is less than or equal to size of k, if not we must remove from the minHeap
        if(minHeap.size() > k) minHeap.poll();
        // we return the kth largest integer in the stream by returning the value at the top of the heap
        return minHeap.peek();
    }
}
