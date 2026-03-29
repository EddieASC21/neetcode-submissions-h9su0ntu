class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones) maxHeap.add(stone);

        while(maxHeap.size() > 1){
            int y = maxHeap.poll(), x = maxHeap.poll();
            if(y != x) maxHeap.add(y - x);
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
