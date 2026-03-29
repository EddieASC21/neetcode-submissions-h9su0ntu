class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // the number of windows we can have based on k and the length of our nums array is nums.length - k + 1 as 0 indexed based
        int[] result = new int[nums.length - k + 1];
        // we initialize a deque to hold the indices of the element in the array
        // deque ensure that we are in decreasing order and that the value at the front of our deque is our current maximum value
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0; i < nums.length; i++){
            // we check if the deque is empty and that the front of the deque is inside our current window, if not we remove from deque
            while(!deque.isEmpty() && deque.peek() < i - k + 1) deque.poll();

            // as said we want to maintain decreasing characteristic of the deque so if the current element is greater than the elements before it/to the left of it, we remove them from the back of the deque
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            
            // after those conditions we now add to the deque
            deque.offer(i);

            // after we process a window, its maximum value which is the front of the deque is added to our result array
            if(i >= k - 1) result[i - k + 1] = nums[deque.peek()];
        }

        return result;
    }
}
