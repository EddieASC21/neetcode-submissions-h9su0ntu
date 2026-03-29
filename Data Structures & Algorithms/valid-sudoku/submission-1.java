class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> subBoard = new HashMap<>();

        for(int row = 0; row < 9; row++){
            for(int column = 0; column < 9; column++){
                if(board[row][column] == '.') continue;

                Set<Character> rowSet = rows.computeIfAbsent(row, k -> new HashSet<>());
                Set<Character> columnSet = columns.computeIfAbsent(column, k -> new HashSet<>());
                Set<Character> subBoardSet = subBoard.computeIfAbsent((row / 3) * 3 + column / 3, k -> new HashSet<>());

                if(rowSet.contains(board[row][column]) || columnSet.contains(board[row][column]) || subBoardSet.contains(board[row][column])) return false;

                rowSet.add(board[row][column]);
                columnSet.add(board[row][column]);
                subBoardSet.add(board[row][column]);
            }
        }
        
        return true;
    }
}
