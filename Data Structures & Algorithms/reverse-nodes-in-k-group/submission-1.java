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
        // we need a dummy node as we begin reversing from the head of the list, it will help with edge cases
        // we set both current and previous to dummy
        ListNode dummy = new ListNode(0), previous = dummy, current = dummy;
        dummy.next = head;

        // we traverse over the entire list to find the amount of nodes present as this helps us determine how many groups of k nodes we can reverse
        int nodes = 0;
        while(current.next != null){
            current = current.next;
            nodes++;
        }

        // within this loop, the nodes are reversed in groups of k
        // with current set to the start of the group
        // nex is initialized to point at the second node in the group
        // the for loop handles the reversing sequence of the nodes in the group
        // after the reverse, the previous pointer now points to current, which is now the end of the reversed group
        // we then decrement the number of nodes by k as after the group of k is reveresed, nodes - k is how many nodes we have left to reverse
        while(nodes >= k){
            current = previous.next;
            ListNode nex = current.next;
            for(int i = 1; i < k; i++){
                current.next = nex.next;
                nex.next = previous.next;
                previous.next = nex;
                nex = current.next;
            }

            previous = current;
            nodes -= k;
        }

        return dummy.next;
    }
}