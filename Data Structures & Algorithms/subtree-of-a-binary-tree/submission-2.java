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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // if the subroot is null then we return true as it can be a subtree of root (for example it could be a "child" of a leaf node)
        // we could also check from the subroot with the help of a recursive helper function to that from the root, if subroot is a subtree of root where if subroot and root are the same tree then it is considered a subtree
        if(subRoot == null || sameTree(root, subRoot)) return true;

        // if root is null and subRoot is not null then that means subRoot cannot be a subtree of a null tree
        if(root == null) return false;

        // we then can check if subroot is a subtree of the left subtree of root or the right subtree of root
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // recursive helper function to see if same tree
    private boolean sameTree(TreeNode root, TreeNode subRoot){
        // we check that up until these points that the trees are the same in the sense that if in both trees we have reached the children and have not returned false by then, it is the same tree
        if(root == null && subRoot == null) return true;

        // we check to see if the structure is the same to see if one node in a tree reaches null first which shows one tree has more nodes than the others or we can check if the values at the current nodes are equal, because if not then it is not true
        if(root == null || subRoot == null || root.val != subRoot.val) return false;

        // we now recursively check the subtrees in root and subroot to see if they are equal and hold for that we can return true
        return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
    }
}