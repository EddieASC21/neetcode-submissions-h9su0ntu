class Solution {
    public void solve(char[][] board) {
        // we now iterate over the entire grid
        // if we are on a "O" and on a border cell
        // we call our helper function
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') helper(board, 0, j);
            if (board[board.length - 1][j] == 'O') helper(board, board.length - 1, j);
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') helper(board, i, 0);
            if (board[i][board[0].length - 1] == 'O') helper(board, i, board[0].length - 1);
        }

        // after we overwrote the board to have the border 'O''s as '#'
        // we now have the remaining 'O''s to be 'X''s
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    // helper function to carry out dfs
    private void helper(char[][] board, int i, int j){
        // base case

        // if we go out of bounds, we return
        // if the cell is not an 'O', we return
        if(i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != 'O') return;

        // we now overwrite the board
        board[i][j] = '#';

        // recursive case
        helper(board, i - 1, j);
        helper(board, i + 1, j);
        helper(board, i, j - 1);
        helper(board, i, j + 1);
    }
}

/*
We are not returning anything

We are overwriting the grid

we are given a 2D grid of characters

Description:

We have a 2D matrix that contains the characters 'X' and 'O'

If a 'O' or group of 'O''s is surrounded by 'X''s on all 4 sides, we consider it surrounded

We must changed all surrounded regions of 'O''s to 'X''s in place

An approach:

We want to do reverse thinking

Instead of finding the 'O' regions that are surrounded, we find the ones that are not surrounded, so those regions at the border and mark it

We then convert all unmarked 'O' to an 'X' as they are surrounded

Then we make all the marked cells into 'O' as they are not surrounded

So then we scan all the border cells, the first and last row and first and last column

If a border cell is a 'O', we perform our algorithm to mark all connected 'O'

After that we iterate over all cells and overwrite all the cells that are 'O' and not marked as 'X'

This works as any 'O' connected to the border cannot be surrounded

Another approach:

We will go through the border and see if we find any 'O''s

We will run dfs on any 'O' we find along the border

With that changing the 'O''s to a place holder

We will then iterate over the entire grid and change all the 'O' to an 'X' as the marked 'O' will be the same
*/