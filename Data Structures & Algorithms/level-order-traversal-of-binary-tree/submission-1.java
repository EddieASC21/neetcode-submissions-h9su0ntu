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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // we create a list that will hold all of our sublists that hold the values of the nodes in each level
        List<List<Integer>> result = new ArrayList<>();

        // we check to see if the root is null as that then means that if it is the beginning of the traversal we have an empty tree and so we return an empty result list
        if(root == null) return result;

        // we will be solving this using bfs as bfs deals with traversing by level, so since we are using bfs, we must initialize a queue
        Queue<TreeNode> queue = new LinkedList<>();
        // we add our root into the queue to begin our bfs
        queue.add(root);

        // we traverse as long as we have nodes to process which would mean as long as the queue is not empty
        // for each iteration, we process one level at a time 
        while(!queue.isEmpty()){
            // we grab the size of queue at this moment as that will tell us the number of nodes in this current level and so how many nodes we must add to our sublist
            int levelSize = queue.size();
            // we now initialize our sublist to then add the current node's values of the current we are on
            List<Integer> level = new ArrayList<>();

            // as we took the size of the queue as the value of the amount of nodes in the current level, we now traverse over those values and add it to our sublist as a representation of the sublist of the nodes and their values within the current level
            for(int i = 0; i < levelSize; i++){
                // we poll the current head of the queue to retract its value to then add to the sublist
                TreeNode current = queue.poll();
                level.add(current.val);
                // once we have done that now we add the children of the node that we just dequeued/poll
                // we add the left children first, if they exist, then add the right children, if they exist, so that it is correctly traversed, we would add these children to the end of the list
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right); 
            }

            // now once we have traversed the entire level, we then add the sublist to our result
            result.add(level);
        } 

        // once we are done traversing the tree as there are no more nodes to process which is taken care of since if the last node has no children, then it doesn't add to the queue and now the queue will be empty, we now just return our list
        return result;
    }
}