/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // we create a hashmap to map the old nodes to their copy
        // the original nodes are used as keys
        Map<Node, Node> map = new HashMap<>();

        // so we iterate over the original linked list and create a copy of each node we visit
        Node current = head;
        while(current != null){
            map.put(current, new Node(current.val));
            current = current.next;
        }

        // we then set the next and random pointers for the new nodes
        current = head;
        while(current != null){
            // we set the next pointer of the copy by accessing the next pointer of our current node from the original linked list via our hashmap
            map.get(current).next = map.get(current.next);
            // we then set the random pointer of the copy by accessing the random pointer of our current node from the original linked list via our hash map
            map.get(current).random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);

    }
}