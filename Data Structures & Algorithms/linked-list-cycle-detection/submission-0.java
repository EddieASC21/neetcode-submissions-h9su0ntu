/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // we set our slow and fast pointer 
        // we set slow as head and fast as head.next so that we don't return true at the start when they start at the same node
        ListNode slow = head, fast = head.next;

        // we iterate as long as we haven't reached the end of the list where the pointer points to null which shows that there is no cycle
        while(fast != null && fast.next != null){
            // we check if our slow and fast pointer is on the same node as that would indicate a cycle
            if(slow == fast) return true;
            // we move our slow pointer by one and our fast pointer by 2
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}