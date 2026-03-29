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
    // global variable
    // we initialize outside the class
    private int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // calling the recursive helper function to find the max depth between the left and right subtree
        depth(root);

        // we return the max diameter seen
        return result; 
    }

    // recursive helper function
    private int depth(TreeNode node){
        // base case
        // if the node is null, we add 0 so it won't have any affect on the diameter or depth
        if(node == null) return 0;

        // we recursively find the max depths of the left and right subtree of the current node
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        
        // at the every node, we compute the current diameter which is the sum of the max depths of the left and right subtree
        int diameter = leftDepth + rightDepth;

        // we update our max diameter by comparing it to the current diameter
        result = Math.max(result, diameter);

        // we then return the current max depth of this node
        // this will help with finding the depth of the parent node
        return 1 + Math.max(leftDepth, rightDepth);
    }
}