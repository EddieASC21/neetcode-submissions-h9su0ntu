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
    public TreeNode invertTree(TreeNode root) {
        // base case
        // we make sure to end our recursive function once a null node is encountered
        // this is helpful when dealing with the children of leaf nodes
        if(root == null) return null;

        // we swap the children of the current node by swapping its left and right children with the help of a temp variable
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // recursive calls
        // after swapping, we recursively call invertTree on both the left and right children, which have been swapped
        // this will help make sure every subtree at every child is inverted
        invertTree(root.left);
        invertTree(root.right);

        // after the subtree that began at its root, we return that root
        // this is important as this will help with higher recusive calls to connect their children correctly
        return root; 
    }
}