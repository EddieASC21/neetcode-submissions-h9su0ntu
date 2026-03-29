/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* Please note that this a binary tree so the values to the left of the root is less than the value of the root and the values to right are greater than that of the root*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // we start at the root to find the LCA
        TreeNode current = root;

        // we traverse the tree until we find the LCA where we reach the end of the tree or where the two nodes are in seperate subtrees
        while(current != null){
            // if both nodes are greater than the current node we are on then we move onto the right subtree to search
            if(p.val > current.val && q.val > current.val) current = current.right;

            // else if both nodes are less than the current node we are on then we move onto to the left subtree to search
            else if(p.val < current.val && q.val < current.val) current = current.left;

            // we return the current node if the value of p or q is equal to the current node's value as we are allowed to say a node is a descendant of itself
            // Also if the nodes p and q are in different subtrees then the LCA is the current node we are on
            else return current;
        }

        // we return null as we are guarenteed a LCA so we will never reach this line
        return null;
    }
}