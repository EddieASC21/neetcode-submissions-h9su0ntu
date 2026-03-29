/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // we initialize a minheap that orders the nodes in ascending value so that we can access the node with the smallest value in constant time
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // we iterate over the arrays of linked lists and add the heads of each array to the heap if non null  
        for(ListNode list : lists){
            if(list != null) minHeap.offer(list);
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // we extract the smallest node which is found at the top of the heap and then append it it to our result list while advancing our pointer for the next iteration
        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;

            // if the node that was just removed has a next node, then we add it to the heap for consideration in the next iteration
            node = node.next;
            if(node != null) minHeap.offer(node);
        }

        return dummy.next;
    }
}