/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // we create a list to help keep track of the values we visit in a preorder
        // traversal manner
        List<String> result = new ArrayList<>();

        // we call our helper function that will perform a preorder traversal slash dfs
        // on the tree starting from the root and adding the values of each node visited
        // to the result list as a string
        serializehHelper(root, result);

        // now given the finalized list after visiting all the nodes by the helper
        // function, we now join these strings of values together as one string with a
        // comma seperating each value which will help us later note what is a child and
        // parent node of said subtree
        return String.join(",", result);
    }

    // recursive helper function that will traverse the tree in a preorder manner
    // using dfs
    private void serializehHelper(TreeNode node, List<String> result) {
        // base case
        // we now check if the current node that we are visiting is null
        if (node == null) {
            // if a node is null, we must mark it null as it help us keep note what is a
            // leaf node
            result.add("null");
            return;
        }

        // we then add the current value of the node we are visiting as a string to our
        // result list
        result.add(String.valueOf(node.val));

        // recursive case
        // we now recursively call the function to carry out the process and traverse
        // over the left subtree and right subtree of the current node until we hit a
        // leaf node which is our base case
        serializehHelper(node.left, result);
        serializehHelper(node.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // we now want to take the list that stored the data on our tree's structure and
        // values of each node and seperate it where a comma is present as that
        // respresents the delimeter seperating each node
        String[] values = data.split(",");

        // we now create an index to help us note which value in the array we are on
        int[] index = { 0 };

        // we now call our recusive helper function that will help us reconstruct our
        // tree based off the values in the array
        return deserializeHelper(values, index);
    }

    // recursive helper function that will help us reconstruct the tree
    private TreeNode deserializeHelper(String[] values, int[] index) {
        // base case
        // if the value of the current index we are on is equal to null, signifying we
        // have reached our base case and its "parent" node is a leaf, we would return
        // null for its value in the tree while updating our index as this node's left
        // or right subtree has been fully visited
        if (values[index[0]].equals("null")) {
            index[0]++;
            return null;
        }

        // now if we are not on a null node, then we create a new tree node for the
        // value we are currently on taking the current index we are on the values array
        // and converting that string into an int
        TreeNode node = new TreeNode(Integer.parseInt(values[index[0]]));

        // after creating this new tree node, we of course update the index we are on in
        // the values array
        index[0]++;

        // recursive case
        // we now iterate over the left and right subtree of the current node taking
        // into the current index and value we are ensuring the reconstruction of both
        // subtrees for the current node if they exist

        node.left = deserializeHelper(values, index);
        node.right = deserializeHelper(values, index);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));