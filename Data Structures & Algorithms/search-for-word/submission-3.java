class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0) return false;
        if(word.length() == 0) return true;

        Set<String> visited = new HashSet<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(search(board, word, 0, i, j, visited)) return true;
                }
            }
        }
        return false;
    }

    private static boolean search(char[][] board, String word, int ind, int i, int j, Set<String> visited){
        if(ind == word.length()) return true;

        String pos = i + "," + j;

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(ind) || visited.contains(pos)) return false;

        visited.add(pos);

        boolean found = (search(board, word, ind + 1, i - 1, j, visited) || search(board, word, ind + 1, i + 1, j, visited) || search(board, word, ind + 1, i, j - 1, visited) || search(board, word, ind + 1, i, j + 1, visited));

        if(found) return true;

        visited.remove(pos);

        return false;
    }
    
}
