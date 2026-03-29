class Solution {
    public int leastInterval(char[] tasks, int n) {
        // we create an array to track the frequencies of the tasks
        int[] counts = new int[26];

        // we iterate over the tash char array and increment as we see the frequency using the ASCII value
        for(char task : tasks) counts[task - 'A']++;

        // we create a max heap to prioritize more frequent tasks 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // we now add all the frequencies to the maxHeap with the greatest frequency being the top of the heap
        for(int count : counts){
            if(count > 0) maxHeap.add(count);
        }

        // we set time variable to return
        int time = 0;
        
        // we now create a queue to handle the cooldown before we can use another task
        // if the queue, we keep track of the task and the time we are able to use the task again
        Queue<int[]> queue = new LinkedList<>();

        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            // we increment time after every cycle
            time++;

            // if the heap is empty, we set the time to be the time of when the next task is available as the queue is yet empty
            if(maxHeap.isEmpty()) time = queue.peek()[1];
            else{
                // when we process a task, we decrement its frequency and add it to the queue with its new available time
                int count = maxHeap.poll() - 1;
                // we check if count is greater than 0 to see if we can add it to queue as it will show we can still process this task
                if(count > 0) queue.add(new int[]{count, time + n});
            }

            // we check if the task at the top of the queue is ready to be processed by comparing its time with the global time and if it is, we add the task to the maxHeap to be processed
            if(!queue.isEmpty() && queue.peek()[1] == time) maxHeap.add(queue.poll()[0]);
        }

        return time;
    }
}