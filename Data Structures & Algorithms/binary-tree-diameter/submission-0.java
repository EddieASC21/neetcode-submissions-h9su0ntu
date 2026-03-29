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
    private int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return result; 
    }

    private int depth(TreeNode node){
        if(node == null) return 0;

        int diameter = depth(node.left) + depth(node.right);
        
        result = Math.max(diameter, result);

        return 1 + Math.max(depth(node.left), depth(node.right));
    }
}
