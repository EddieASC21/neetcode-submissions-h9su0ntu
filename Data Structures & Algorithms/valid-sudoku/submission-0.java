class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> subBoard = new HashMap<>();

        for(int row = 0; row < 9; row++){
            for(int column = 0; column < 9; column++){
                if(board[row][column] == '.') continue;

                if(rows.getOrDefault(row, new HashSet<>()).contains(board[row][column]) || columns.getOrDefault(column, new HashSet<>()).contains(board[row][column]) || subBoard.getOrDefault((row / 3) * 3 + column / 3, new HashSet<>()).contains(board[row][column])) return false;

                columns.computeIfAbsent(column, k -> new HashSet<>()).add(board[row][column]);
                rows.computeIfAbsent(row, k -> new HashSet<>()).add(board[row][column]);
                subBoard.computeIfAbsent((row / 3) * 3 + column / 3, k -> new HashSet<>()).add(board[row][column]);
            }
        }
        
        return true;
    }
}
