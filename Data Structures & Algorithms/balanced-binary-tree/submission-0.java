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
        return depth(root) != -1;
    }

    private int depth(TreeNode node){
            if(node == null) return 0;

            int leftDepth = depth(node.left);
            int rightDepth = depth(node.right);

            if((leftDepth == -1) || (rightDepth == -1) || (Math.abs(leftDepth - rightDepth) > 1)) return -1;

            return 1 + Math.max(leftDepth, rightDepth);
        }
}
