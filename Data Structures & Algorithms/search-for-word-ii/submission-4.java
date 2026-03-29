// we will create a Trie to help keep track of the words that we must find in the grid
public class TrieNode {
    // each trie node will have children which correlates to the 26 lower case
    // letters
    TrieNode[] children = new TrieNode[26];

    // the way we keep track of what is a word in the trie is by marking the last
    // node as true to show that it is the end of a word
    boolean endOfWord = false;
}

class Solution {

    // we create the function to insert the words in the array we are searching into
    // the trie
    public void insert(TrieNode root, String word) {
        // we start at the root of the trie
        TrieNode current = root;

        // we now iterate over each character on the word
        for (char c : word.toCharArray()) {
            // we find the index of the current characyer we are visiting to add into the
            // children array
            int index = c - 'a';

            // we check if the current character is a node in the trie because if not we
            // will add a node to the trie for this character
            if (current.children[index] == null)
                current.children[index] = new TrieNode();

            // now if the character exists in the trie, we move onto this node and begin the
            // next part of the iteration
            current = current.children[index];
        }

        // once we have iterated over all the words in the array, we mark the last
        // character/node as the end of the word and mark it true
        current.endOfWord = true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        // now in our solution, we start at the root of the trie and so we instantiate a
        // trie node
        TrieNode root = new TrieNode();

        // we now add all the words in the array we are searching for in the array
        for (String word : words)
            insert(root, word);

        // we create a hashset which will hold all the words found in the board, we are
        // using a set that way there are no duplicates found as words could be found
        // within multiple paths in the board
        Set<String> result = new HashSet<>();

        // we create a boolean 2D array to keep track of the cell in the board that has
        // been visited as we want to ensure that we are not using the same cell more
        // than once in a word
        // we also use a 2D array instead of a hashset is because using a set would give
        // us time limit exceeded for the last test case
        boolean[][] visited = new boolean[board.length][board[0].length];

        // we now iterate over all the cells in the board
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                // we call the recursive helper function to run dfs on our grid to see if it can
                // find one of the words in the trie as a path in the board
                helper(board, row, column, root, "", visited, result);
            }
        }

        // we now return our answers that is stored in our set as an array as that is
        // what the return type of this function
        return new ArrayList<>(result);
    }

    // recursive helper function to run dfs on the board to see if a word in the
    // trie could be found within the board
    private void helper(char[][] board, int row, int column, TrieNode node, String word, boolean[][] visited,
            Set<String> result) {
        // base case

        // we check if we are in bounds within our row and column, we also ensure that
        // the current cell has not been visited
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || visited[row][column])
            return;

        // we now take teh character from the current cell we are on
        char c = board[row][column];

        // we now take the index of this character
        int index = c - 'a';

        // based off the character we are on and index we found, we search if this
        // character exists as a node in the trie else we would return
        if (node.children[index] == null)
            return;

        // now if this character exists in the trie then we would mark this cell in the
        // bpard as visited as we begin the search
        visited[row][column] = true;

        // we now update the current node we are on to the next one as we begin to
        // explore its children knowing that this node exists in the trie
        node = node.children[index];

        // we now add the current character we are on to our string word that will be
        // added to the set if a complete word
        word += c;

        // now if the node we are on is marked as the end of the word in the trie, then
        // we have found a complete word and add it to the set
        if (node.endOfWord)
            result.add(word);

        // recursive call
        // we now call our function on the next cell updating our row pointer going left
        // or right and column pointer going down or up
        helper(board, row - 1, column, node, word, visited, result);
        helper(board, row + 1, column, node, word, visited, result);
        helper(board, row, column - 1, node, word, visited, result);
        helper(board, row, column + 1, node, word, visited, result);

        // as we are backtrackin due to this cell can be used to find another word in
        // the board, we must now mark the cell back to unvisited
        visited[row][column] = false;
    }
}