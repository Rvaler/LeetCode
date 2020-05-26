class Solution {
    public boolean exist(char[][] board, String word) {
        
        if(word == null)
            return false;
        
        if(word.length() == 0)
            return true;
        
        int rows = board.length;
        int cols = board[0].length;
        
        char firstChar = word.charAt(0);
        
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                boolean foundWord = 
                        searchWord(board, new boolean[rows][cols], word, 0, rows, cols, row, col);
                if(foundWord)
                        return true;
            }
        }
        
        return false;
    }

    
    public boolean searchWord(char[][] board, boolean[][] visited, String word, int index, int rows, int cols, int row, int col) {
        
        if(index >= word.length()) // found word
            return true;
        
        if(row < 0 || row >= rows || col < 0 || col >= cols) // out of bounds
            return false;
        
        if(visited[row][col] == true)
            return false;
        
        if(word.charAt(index) != board[row][col])
            return false;
        
        Character c = board[row][col];
        visited[row][col] = true;
        
        boolean left = searchWord(board, visited, word, index + 1, rows, cols, row, col - 1);
        if(left)
            return true;
        boolean right = searchWord(board, visited, word, index + 1, rows, cols, row, col + 1);
        if(right)
            return true;
        boolean up = searchWord(board, visited, word, index + 1, rows, cols, row - 1, col);
        if(up)
            return true;
        boolean down = searchWord(board, visited, word, index + 1, rows, cols, row + 1, col);
        if(down)
            return true;
        
        visited[row][col] = false;
        return false;
    }
}