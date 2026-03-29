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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base case
        // if both roots are null then we have an empty tree so we return true 
        // but could also mean that we have reached both ends of the tree and if we havemt't returned false by then, we return true
        if(p == null && q == null) return true;

        // we check if one the nodes is null which could mean that one tree has more nodes than the other which means a difference in structures and we also check if the nodes we are on have the same value, if any of these things are true then we return false
        if(p == null || q == null || p.val != q.val) return false;

        // recursive case
        // we now check the current node's right and left subtree where we return true if both subtrees are balanced
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }   
}