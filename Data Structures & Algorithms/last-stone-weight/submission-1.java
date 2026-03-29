class Solution {
    public int lastStoneWeight(int[] stones) {
        // we initialize a maxHeap such that the root of the heap will be the maximum weight
        // we say reverse orders as priority queues are set to default to be minHeaps
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // we add the weights of the stones into the heap
        for(int stone : stones) maxHeap.add(stone);

        // we now pop off the heaviest stones from the heap as long as there are two stones in the heap
        while(maxHeap.size() > 1){
            // when we pop from the top of the heap, we are popping off the heaviest stone as with a maxHeap, the root is the greatest value within the heap
            // if we pop off again, after popping once, we now get the second heaviest stone
            int y = maxHeap.poll(), x = maxHeap.poll();
            // we now see if the values of y and x are equal because if not we subtract x from y and add the difference back into the heap
            if(y != x) maxHeap.add(y - x);
        }

        // we then check if the heap is empty and if so we return 0 else we return the last weight of the stone in the heap which we can access by peeking the value of the root which is the top of the heap
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}