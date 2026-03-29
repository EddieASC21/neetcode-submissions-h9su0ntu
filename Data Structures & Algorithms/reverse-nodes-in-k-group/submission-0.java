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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0), current = dummy, previous = dummy;
        dummy.next = head;

        int len = 0;

        while(current.next != null){
            current = current.next;
            len++;
        }

        while(len >= k){
            current = previous.next;
            ListNode nex = current.next; 
            for(int i = 1; i < k; i++){
                current.next = nex.next;
                nex.next = previous.next;
                previous.next = nex;
                nex = current.next;
            }

            previous = current;
            len -= k;
        }

        return dummy.next;
    }
}
