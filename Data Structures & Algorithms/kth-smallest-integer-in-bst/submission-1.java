/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // we initialize a stack to help process the nodes in order traversal
        Stack<TreeNode> stack = new Stack<>();

        // we set root to current as that will be the first node we would add to the stack
        TreeNode current = root;

        // we set a counter to keep track of the number of elements processed, this will help us know when we have reached k
        int count = 0;

        // we iterate as long as the tree still has nodes to process or the stack still has nodes to process
        while(current != null || !stack.isEmpty()){
            // we traverse while current is null as we want to push all the left children first until we have hit null as we want to process the left children first
            while(current != null){
                // we push the current node to the stack to be processed
                stack.push(current);

                // we now move our current pointer to traverse to the left
                current = current.left;
            }

            // once we hit null when we are traversing the left side, then we will pop the most recent value from the stack to be processed
            current = stack.pop();

            // as we have processed this node and we have popped from the stack, we can now increment the number of nodes we have visited
            count++;

            // if the number of nodes we have processed is now equal to k, we return the value of the most recent node we processed
            if(count == k) return current.val;

            // if no more left children to push from the subtree, we now traverse over the right subtree and the inner loop will begin again in hopes of finding left children to process first within this subtree
            current = current.right;
        }

        // this will never be reached as we are told that k is less than or equal to the number of nodes in the tree by the constraints
        return -1;
    }
}