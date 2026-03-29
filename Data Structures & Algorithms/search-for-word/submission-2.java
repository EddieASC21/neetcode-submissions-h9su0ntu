class Solution {
    public boolean exist(char[][] board, String word) {
        // we check if the board is empty
        if(board.length == 0) return false;

        //check if we have a word
        if(word.length() == 0) return true;

        // we create a hashset to keep track of all of the cells visited
        Set<String> visited = new HashSet<>();

        // iterate over every cell
        for(int row = 0; row < board.length; row++){
            for(int column = 0; column < board[0].length; column++){
                // if the index we are on is the first character of the word, we call the helper function
                if(board[row][column] == word.charAt(0)){
                    // if the helper function is completed successfully then we have found the word and so return true
                    if(search(board, word, row, column, 0, visited)) return true;
                } 
            }
        }
        // we didn't find the word
        return false;
    }
    
    // recursive dfs helper function
    private static boolean search(char[][] board, String word, int row, int column, int index, Set<String> visited){
        // check if we found the word which is if our index is at the last character of our word
        if(index == word.length()) return true;

        // we check if we are in bounds
        boolean rowInBounds = 0 <= row && row < board.length;
        boolean columnInBounds = 0 <= column && column < board[0].length;

        if(!rowInBounds || !columnInBounds) return false;

        // check if the character we are on is not in the word
        if(board[row][column] != word.charAt(index)) return false;

        // now we will create positions to help keep track of cell visited
        String position = row + "," + column;

        // check if we have already visited this cell when doing our search
        if(visited.contains(position)) return false;

        // now when doing the search we must mark cells visited to aviod infinite call
        visited.add(position);

        // recursive calls
        boolean foundWord = search(board, word, row - 1, column, index + 1, visited) || search(board, word, row + 1, column, index + 1, visited) || search(board, word, row, column - 1, index + 1, visited) || search(board, word, row, column + 1, index + 1, visited);

        // if we found the word, we return true
        if(foundWord) return true;

        // we backtrack if word is not found
        visited.remove(position);

        // we return false if we didn't find the word
        return false;
    }

}
