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
    public ListNode reverseList(ListNode head) {
        // we have previous set to null as the next of our new head should be null
        // current points to the head of the linked list as that is where we shall begin our reversal
        ListNode previous = null, current = head;

        while(current != null){
            // we want to store current.next in a temp variable before change it so we don't lose it 
            ListNode temp = current.next;
            // we reverse the current nodes pointer
            current.next = previous;
            // we update our previous to pointer to current
            previous = current;
            // we move current to point to the next node in the list
            current = temp;
        }

        // previous will be the new head of the list as current points to null
        return previous;
    }
}
