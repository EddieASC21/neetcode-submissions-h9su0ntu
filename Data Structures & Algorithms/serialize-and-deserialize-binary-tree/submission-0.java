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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> result = new ArrayList<>();
        serializeHelper(root, result);
        return String.join(",", result); 
    }

    private void serializeHelper(TreeNode node, List<String> result){
        if(node == null){
            result.add("null");
            return;
        }

        result.add(String.valueOf(node.val));
        serializeHelper(node.left, result);
        serializeHelper(node.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        int[] index = {0};
        return deserializeHelper(values, index);
    }

    private TreeNode deserializeHelper(String[] values, int[] index){
        if(values[index[0]].equals("null")){
            index[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(values[index[0]]));
        index[0]++;
        node.left = deserializeHelper(values, index);
        node.right = deserializeHelper(values, index);

        return node;
    }
}
