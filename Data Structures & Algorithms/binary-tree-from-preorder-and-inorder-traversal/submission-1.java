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
    
    // we set our global variables that is a part of the class
    // this so that it can be accessed by any function
    // we have the preorderIndex node to help keep track of the index we find ourselves in the preorder tree as the first value in the preorder array, we will use as the root of our subtrees
    int preorderIndex = 0;
    // we have inorderIndex that tracks the current index we find ourselves in the inorder array as we will use this index to check against the boundaries
    // the example we can use when saying we are using this index to check against boundaries is that we know that the index of the preorderIndex, the head of the array, is used as the root node for our binary tree so we then track what nodes are to the left of it and the right of it in the in order tree as this will demonstrate what nodes are in the left and right subtree and recursively note the structure
    int inorderIndex = 0;
    // so for example for preorder = [3, 9, 20, 15, 7] and inorder = [9, 3, 15, 20, 7]
    // we note that the head of preorder is 3 and so the root of the tree so we "pop" it off and so preorder and now have [9, 20, 15, 7] and so then we take the index of 3 in inorder and not that to the left of 3 is [9] and [15, 20, 27], so [9] is in the left subtree and [15, 20, 7] is in the right subtree and so now we note the next node in preorder array which is 9, so 9 is the root of the left subtree as it is to left of 3, but when we check it against other boundaries we note that there are no nodes to the left and right of 9 in the inorder array so the left subtree is complete, now as we popped 9 from the array, we now have the preorder array as [20, 15, 7] and so we note that as this subarray is to the right of 3, this is the right subtree and so the first node is 20 in the preorder array so the root of the right subtree is 20 and so now we check its index in the inorder array, [15, 20, 7], we note that there is one node to the right and left of 20 in the inorder array and so [15] being to the left is gonna be the left subtree in this tree and as [7] is on the right side of [20] in the array then we note that 20 will be in the right subtree of this tree and so we continue and now our preorder array is [15, 7] as we have now popped 20, so now 15 is the head and will be popped, we note that 15 will be in the left subtree and so 15 is the new root node of the left subtree within this tree and so we check its boundaries to see what may be its future children, we do the same for [7] as we note it is now the root of the right subtree in this tree and we also note its boundaries to see ut future children, we note that both have no boundaries to check against so that means these are leaf nodes and as we pop of 7, we have an empty array for both the preorder and inorder array proving that we have constructed both trees
    // note we construct these trees using recursion
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // we now call our recursive helper function to help recursively build our left and right subtree
        // we take in a boundary parameter as this will help keep track of the value in the inorder array that can't be added to the current subtree
        // this will help find the left and right bounds of the current subtree
        return construct(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode construct(int[] preorder, int[] inorder, int max){
        // base case
        // if preorderIndex is greater than the length of the preorder array then that means we have processed all of the nodes in the preorder array and the array is now empty, so we can return null
        if(preorderIndex >= preorder.length) return null;

        // if the current inorder value is euqal to the boundary, that means we have reached the end of the current subtree and so now we would move onto the next index and return null
        if(inorder[inorderIndex] == max){
            inorderIndex++;
            return null;
        }

        // after a new TreeNode is created using the current preorderIndex in the preorder array, we update and increment preorderIndex to use the next value to create a treenode for the next recursive call
        TreeNode root = new TreeNode(preorder[preorderIndex++]);

        // recursive case
        // we call the construct function on the left child where we set the boundary to current root's value which limits the left subtree values before this node on the inorder array
        root.left = construct(preorder, inorder, root.val);
        // we call the construct function on the right child where we use the original boundaries allowing us to recursively call the function until we hit the parent boundary or we complete the construction of the subtree
        root.right = construct(preorder, inorder, max);

        return root;
    }
}