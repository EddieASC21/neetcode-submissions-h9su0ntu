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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // we create a dummy node to help us merge the lists
        ListNode dummy = new ListNode(0);
        // we set a node to move throughout the list and starts at the dummy node 
        ListNode node = dummy;

        // we iterate as long as both lists are nonempty
        while(list1 != null && list2 != null){
            // we compare the current nodes of list1 and list2
            // we take the lesser value and set it as the next node in our merged list and then advance our pointer from the list we took the smaller value from
            if(list1.val <= list2.val){
                node.next = list1;
                list1 = list1.next;
            }
            else {
                node.next = list2;
                list2 = list2.next;
            }

            // we update the pointer in our merge list after a value is assigned
            node = node.next;
        }

        // if one of the list is still nonempty then we add the remaining values to the end of the merge list
        if(list1 == null) node.next = list2;
        else node.next = list1;

        // we return dummy.next as it points to the head of the merged list
        return dummy.next;
    }
}