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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // we use a dummy node to handle edge cases
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        int carry = 0;

        // we iterate until both lists are traversed and we have no carry left
        while(l1 != null || l2 != null || carry != 0){
            // we make sure that when a list is fully traversed, its "next" values are treated as 0, this helps when adding two lists of different lengths 
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // we calculate the sum with taking into account the current carry
            int sum = x + y + carry;
            // we now calculate the new carry by dividing our sum by 10 as if the sum is >= 10 then the carry is 1 else carry is 0
            carry = sum / 10;
            // we create a new node in our result list with the ones place of our currnt sum
            // taking sum % 10 would give us the ones place of our sum and the value of our new node
            current.next = new ListNode(sum % 10);
            // we then shift our pointer to the next node to be instantiated in our result list
            current = current.next;
            // we also increment our l1 and l2 pointer as long as we have not traveresed the whole list(s) to then evaluate the next sum and the next value to be added in our result list
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}