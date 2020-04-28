class Solution {
    public void solveSudoku(char[][] board) {
        
        boolean[][] rowsPositions = new boolean[9][9]; // if [0][5] == True, means that row 0 has a 5
        boolean[][] colsPositions = new boolean[9][9]; // if [0][5] == True, means that col 0 has a 5
        boolean[][] quadrantPositions = new boolean[9][9];
        
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                if(board[row][col] != '.') {
                    int value = (int)(board[row][col] - '0');
                    rowsPositions[row][value - 1] = true;
                    colsPositions[col][value - 1] = true;
                    quadrantPositions[(row / 3) * 3 + (col / 3)][value - 1] = true;
                }
            }
        }
        
        solveSudoku(board, 0, 0, rowsPositions, colsPositions, quadrantPositions);
    }
    
    public boolean solveSudoku(char[][] board, int row, int col, boolean[][] rowsPositions, boolean[][] colsPositions, boolean[][] quadrantPositions) {
        
        if(row >= 9) {
            return true;
        }
        
        if(col >= 9) { // switch to new row
            return solveSudoku(board, row + 1, 0, rowsPositions, colsPositions, quadrantPositions);
        }
        
        if(board[row][col] == '.') { // if cell is empty
            
            for(int i = 1; i <= 9; i++) {
                board[row][col] = (char)('0' + i);
                if(checkValid(row, col, board, rowsPositions, colsPositions, quadrantPositions)) {
                    rowsPositions[row][i - 1] = true;
                    colsPositions[col][i - 1] = true;
                    quadrantPositions[(row / 3) * 3 + (col / 3)][i - 1] = true;
                    if(solveSudoku(board, row, col + 1, rowsPositions, colsPositions, quadrantPositions))
                        return true;
                    rowsPositions[row][i - 1] = false;
                    colsPositions[col][i - 1] = false;
                    quadrantPositions[(row / 3) * 3 + (col / 3)][i - 1] = false;
                }
                board[row][col] = '.';
            }
            
            return false;
        } else {
            return solveSudoku(board, row, col + 1, rowsPositions, colsPositions, quadrantPositions); 
        }
    }
    
    public boolean checkValid(int row, int col, char[][] board, boolean[][] rowsPositions, boolean[][] colsPositions, boolean[][] quadrantPositions) {
        int value = board[row][col] - '0';
        if(rowsPositions[row][value - 1])
            return false;
        if(colsPositions[col][value - 1])
            return false;
        if(quadrantPositions[(row / 3) * 3 + (col / 3)][value - 1])
            return false;
        
        return true;
    }
}