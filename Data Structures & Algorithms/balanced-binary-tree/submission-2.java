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
    public boolean isBalanced(TreeNode root) {
        // we call our helper function on the root and see if the value returned is equal to -1 which then means the tree is unbalanced, if not we return true
        return depth(root) == -1 ? false : true;
        }

        // recursive helper function to help find the max depth of the current node and its subtree
        private int depth(TreeNode node){
            // base case
            // if we have an empty subrtree, we would return 0 as has no affect on the depth
            if(node == null) return 0;

            // we calculate the depth of the left and right subtree recursively
            int leftDepth = depth(node.left), rightDepth = depth(node.right);

            // we then check if our subtree at current node is balanced
            // if the absolute difference between the leftDepth and rightDepth greater than 1, we return -1 as inbalanced or if the subtree depths were equal to -1 then we return -1 as now the current node's subtree we are on is also inbalanced
            if((leftDepth == -1) || (rightDepth == -1) || (Math.abs(leftDepth - rightDepth) > 1)) return -1;

            // returning the max depth of the current node and its subtree helps ensure we can use that value when finding if the root or parent of that node is also balanced
            return 1 + Math.max(leftDepth, rightDepth);
    }
}