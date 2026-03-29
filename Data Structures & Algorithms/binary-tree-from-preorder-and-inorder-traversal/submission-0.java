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
    int preorderIndex = 0;
    int inorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode construct(int[] preorder, int[] inorder, int max){
        if(preorderIndex >= preorder.length) return null;
        if(inorder[inorderIndex] == max){
            inorderIndex++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderIndex++]);

        root.left = construct(preorder, inorder, root.val);
        root.right = construct(preorder, inorder, max);

        return root;
    }
}
