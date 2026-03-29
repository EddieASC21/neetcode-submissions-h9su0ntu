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
    // we set a global vairable to keep track of the greatest oath sum we have seen so far
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // we call our recursive helper function that will return max sum of the left or right subtree plus the root as we want to return back the max sum we could achieve without spliting
        pathSum(root);
        // we end up returning the max sum we see throughout our recursive calls and as we traverse the tree
        return maxSum;
    }

    // recursive dfs helper function to help find the max path sum in the tree while returning the max value of the two subtrees plus the root node
    private int pathSum(TreeNode node){
        // base case
        // we return 0 if the node is null as it will have no affect to the sum of the path if it is null
        if(node == null) return 0;

        // recursive case
        // we call the function on both the left and right subtree to find the max value between the two as we will take into consideration into what path to take and add to while also noting that the path may contain negative numbers so we take care of this edge case by passing by taking the max of the current subtree path and 0
        int leftPath = Math.max(pathSum(node.left), 0);
        int rightPath = Math.max(pathSum(node.right), 0);

        // we store the sum if we were to split paths as in visit the left and right subtree rather than going down one side
        int currentPath = node.val + leftPath + rightPath;
        // we now compare the value of our current max sum and the new sum of splitting between both subtrees and updating our max sum
        maxSum = Math.max(maxSum, currentPath);

        // we then return the max value we would get from traversing down one tree as we cannot split more than one time in the sense that we cannot visit a node more then once so we return at the top the max of the root value and its corresponding path
        return node.val + Math.max(leftPath, rightPath);
    }
}