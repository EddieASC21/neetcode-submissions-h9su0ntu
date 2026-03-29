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

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxSum;
    }

    private int pathSum(TreeNode node){
        if(node == null) return 0;

        int maxLeft = Math.max(pathSum(node.left), 0);
        int maxRight = Math.max(pathSum(node.right), 0);

        int currentPath = node.val + maxLeft + maxRight;

        maxSum = Math.max(maxSum, currentPath);

        return node.val + Math.max(maxLeft, maxRight);
    }
}
