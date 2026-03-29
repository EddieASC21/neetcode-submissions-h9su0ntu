class Solution {
    public List<List<String>> solveNQueens(int n) {
        // sets to keep track of where we can't place the next queen
        Set<Integer> column = new HashSet<>();

        // determined by row - column
        Set<Integer> negativeDiagonal = new HashSet<>();

        // determined by row + column
        Set<Integer> positiveDiagonal = new HashSet<>();

        // this will be our output
        List<List<String>> output = new ArrayList<>();

        // we maintain a board
        // where n is our int to show our number of rows and columns
        // we fill the board with '.' to show empty spots 
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');

        helper(column, negativeDiagonal, positiveDiagonal, output, board, 0, n);

        return output;
    }

    // recursive backtracking helper function
    private void helper(Set<Integer> column, Set<Integer> negativeDiagonal, Set<Integer> positiveDiagonal, List<List<String>> output, char[][] board, int row, int n){
        // base case

        // if we reach row n, we were able to find a valid solution
        if(row == n){
            // we make the board a string rather than an array
            List<String> validBoard = new ArrayList<>();
            // we will take each row and join them together
            for (char[] r : board) validBoard.add(new String(r));
            output.add(validBoard);
            return;
        }

        // recursive case

        // we go through every position in the row we are at
        // we will see where we can place a queen
        for(int c = 0; c < n; c++){
            // if our position is in either one of our sets, we continue to the next position
            if(column.contains(c) || negativeDiagonal.contains(row - c) || positiveDiagonal.contains(row + c)) continue;

            // we are on a position we can use so update our sets
            column.add(c);
            negativeDiagonal.add(row - c);
            positiveDiagonal.add(row + c);

            // we must update the board
            // in the valid position, we now update for their to be a 'Q' in that position
            board[row][c] = 'Q';

            // recursive case
            helper(column, negativeDiagonal, positiveDiagonal, output, board, row + 1, n);

            // backtrack
            // we back track from what we just did to see if multiple solutions exist

            // we now remove the position

            // we remove from our sets
            column.remove(c);
            negativeDiagonal.remove(row - c);
            positiveDiagonal.remove(row + c);

            // we update our board
            // we set the 'Q' back to a '.'
            board[row][c] = '.';
        }
    }
}

/*
We are to return a list of list of strings

We are given an integer

So from the description

we are to place on n queens on a n x n board so that no two queens can attack each other

We note the movement of a queen being moving horizontally, vertically, and diagonally

given the integer n, we must return all distinct solutions to the puzzle

Each solution must contain a unique layout where queens can be placed

'Q' indicates queen and '.' is empty space

An approach:

We would place the queens on each row backtracking where there is a conflict

Since we are placing one queen a row, we can assume to some sense that rows are safe

So we will track columns and diagonals to avoid conflict

So we will use sets to keep track where the queens have been placed

One set will be the columns where queens are placed

Another set will keep track of the left diagonals which is rows minus columns

the next set will track the right diagonals which is columns plus rows

So our recursive backtracking will look like this

we start at row 0

then for each column in that row

check if we can place the queen there safely

if it is safe, we now mark the position, and recurse to next row

after this, we remove the queen to backtrack

if we find that the current row index we are on is equal to n, we add it our result as a string

Another approach:

We know that each queen will be in a different row

We also note we have to keep track of the columns of the previous queens place

no need to keep track of the row as when we [;ace a queen, we will move onto the next row until we hit the bottom

We also keep tracks of the left and right diagonals

we will keep track all of this with a set

For the left to right/negative diagonal, as we move by one step, we increase both the column and row by 1

This means for the negative diagonal, row - column will stay constant, will remain 0, so r - c = 0

For the right to left/positive diagonal, we increase the column by one and decreasing the row by one, so row + column will stay the same as we move along the diagonal

As we begin

We will try all of the n positions in the first row

then we will recursively do the same for the next rows while checking against our sets
*/
