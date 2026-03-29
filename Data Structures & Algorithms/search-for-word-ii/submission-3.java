public class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class Solution {

    public void insert(TrieNode root, String word){
        TrieNode current = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(current.children[index] == null) current.children[index] = new TrieNode();
            current = current.children[index];
        }

        current.endOfWord = true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for(String word : words) insert(root, word);

        Set<String> result = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int row = 0; row < board.length; row++){
            for(int column = 0; column < board[0].length; column++){
                search(board, row, column, root, "", visited, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void search(char[][] board, int row, int column, TrieNode root, String word, boolean[][] visited, Set<String> result){        
        if(row < 0 || row >= board.length || column < 0 || column >= board[0].length || visited[row][column]) return;

        char c = board[row][column];
        int index = c - 'a';

        if(root.children[index] == null) return;

        visited[row][column] = true;

        root = root.children[index];
        word += c;

        if(root.endOfWord) result.add(word); 

        search(board, row - 1, column, root, word, visited, result);
        search(board, row + 1, column, root, word, visited, result);
        search(board, row, column - 1, root, word, visited, result);
        search(board, row, column + 1, root, word, visited, result);

        visited[row][column] = false;
    }
}