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
    public int maxDepth(TreeNode root) {
        // base case
        // we return 0 if the root is null as it doesn't add to the depth

        // recursive call
        // we find the depth of the current node we are on by adding one due to the current node being non null and adding it to the max depth of both the right and left subtrees
        return root == null ? 0 : 1 + Math.max((maxDepth(root.left)),(maxDepth(root.right)));
    }
}