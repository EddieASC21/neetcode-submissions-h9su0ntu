/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root){
        // we call our recursive helper function to validate our binary search tree
        // starting from the root and setting the initial bounds to be negative and
        // "positive" infinity
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // recursive helper function
    private boolean validate(TreeNode node, long min, long max){
        // if the node is null then we return true because an empty subtree is valid subtree 
        // this may mean that we have reached the end of the subtree and if we haven't return false then the entire subtree is valid
        if(node == null) return true;

        // we return false if the node's value is greater than the max value or the node's value is less than the min in which we return false
        // the node's value must be less than the max and greater than the min as per the nature of a bst
        if(node.val <= min || node.val >= max) return false;

        // we now check and validate the node's left and right subtree to see if they are valid binary search trees
        boolean validLeft = validate(node.left, min, node.val);
        boolean validRight = validate(node.right, node.val, max);

        // we return both validLeft and validRight as both subtrees must be valid to be a valid tree
        return validLeft && validRight;
    }
}