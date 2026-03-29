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
    public void reorderList(ListNode head) {
        
        // we use a slow and fast pointer to find the middle of the list
        // when the fast pointer reaches the end of the list, the slow pointer will be at the middle
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        // after we have found the middle of the list, we split the list into two by setting slow.next to be null
        ListNode prev = slow.next = null;

        // we now reverse the second half of the list starting from sec
        // prev now is pointing to the head of the reversed half of the list after the loop has terminated
        while(second != null){
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        // first points to the head of the entire list 
        ListNode first = head;
        // second points to prev which points to the head of the reverse half of the list
        second = prev;

        // we now merge the list taking from the first half of the list then the second half then the first half again and so on
        while(second != null){
            ListNode temp1 = first.next, temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }

    }
}