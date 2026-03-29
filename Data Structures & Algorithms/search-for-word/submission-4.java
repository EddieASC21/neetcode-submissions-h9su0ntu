class Solution {
    public boolean exist(char[][] board, String word) {
        // we keep track of visited cells using a set so no cycles happen
        Set<String> visited = new HashSet<>();

        // we now iterate the entire board
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(helper(board, word, 0, i, j, visited)) return true;
            }
        }

        return false;
    }

    // recursive backtracking helper function
    private boolean helper(char[][] board, String word, int index, int i, int j, Set<String> visited){
        // base case

        // if we reach at the end of word or the index is at the last position, we have found the word and can return true
        if(index == word.length()) return true;

        // we check if we go out of bounds or if the cell is not equal to the character we are on in our word or if we have already visited the cell
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(index) != board[i][j] || visited.contains(i + "," + j)) return false;

        // we add our cell to our set to mark visited
        visited.add(i + "," + j);

        // we call dfs on every adjacent cell to help find a valid path
        boolean foundWord = (helper(board, word, index + 1, i - 1, j, visited) || helper(board, word, index + 1, i + 1, j, visited) || helper(board, word, index + 1, i, j - 1, visited) || helper(board, word, index + 1, i, j + 1, visited));

        // we remove the position we just add as we are no longer visiting and will help backtrack
        visited.remove(i + "," + j);

        return foundWord;
    }
}

/*
We are returning a boolean for if a sequence of characters exists in a grid

So we are given a 2-D grid that is populated with characters and a string word where we are searching for its presence on the grid

We will return true or false dependent on the presence of the string in the gird

So we determine that a word is present if we can form a path to find it

the path must be form in the board using horizontal and vertical neighboring cells

We cannot use the same cell more than once for one word

We have an example:

board = [
  ["A","B","C","D"],
  ["S","A","A","T"],
  ["A","C","A","E"]
],
word = "CAT"

We can iterate through the board from the row and columns

so we land on c in the first row as matches first letter of our word

so then we go on and see the neighboring cells and see an a which matches the next letter

we then iterate and see that t is the next letter and is a neighbor

so we found a valid path in our grid

so we can return true 

An approach:

We can use DFS and Backtracking

We would visit every cell on the board

if the cell matched the first letter of our word, we run dfs on that cell

We would explore all 4 directions while using a visited cell to avoid cycles

after visiting a path that didn't meet what we needed, we backtrack so we can run dfs on the next valid cell

Another approach

We will use backtracking

We go through every cell and find for the letter our word starts with then look for the next letter in the cell and etc

We also keep track that we don't visit the same cell twice
*/
