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
    public int goodNodes(TreeNode root) {
        // we call our helper function on the root and its value as we are guarenteed that the root is a good note and so will also be the maximum value we have seen so far
        return count(root, root.val);
    }

    // recursive helper function to carry out dfs on the tree
    private int count(TreeNode node, int value){
        // base case
        // if the current node is null then we return 0 as there is no node to count
        if(node == null) return 0;

        // we set our counter to keep track of the amount of good nodes we find in a path
        int num = 0;

        // we check if the current node we are on is greater than or equal to the value of current max, value, as that means we have a good node and so we increment the count 
        if(node.val >= value) num++;

        // we update the max within a path for the next call
        // we update by comparing it to the current max and the current node's value
        value = Math.max(value, node.val);

        // recursive case
        // we recursively call the function on the left and right subtrees of the current node and add it to the current number of good nodes if a node is found to be good in this path
        num += count(node.left, value);
        num += count(node.right, value);

        // we return the number of good nodes found in the path
        return num;
    }
}