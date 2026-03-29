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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // we add a dummy node in the case that we must remove the head of the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;

        // we move the fast pointer n steps ahead of the slow pointer
        // the reason being once the fast pointer hits the end of the list, the slow pointer will be one node behind our target node which will later help us remove the target node from the list
        while(n >= 0){
            fast = fast.next;
            n--;
        }

        // this loop will continue until the fast pointer reaches the end of the list
        // so then the slow pointer will be one node before our target node
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        // as the next pointer after slow if our target pointer, we skip over it thus removing it from the list
        slow.next = slow.next.next;

        return dummy.next;
    }
}