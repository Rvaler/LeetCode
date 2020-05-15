class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        
        int rows = matrix.length;
        if(rows == 0)
            return 0;
        int cols = matrix[0].length;
        if(cols == 0)
            return 0;
        
        int memo[][] = new int[rows][cols];
        for(int[] m: memo) 
            Arrays.fill(m, -1);
        
        int maxPath = 0;
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                maxPath = Math.max(maxPath, longestIncreasingPath(matrix, row, col, Integer.MIN_VALUE, 0, memo));
            }
        }
        
        return maxPath;
    }
    
    public int longestIncreasingPath(int[][] matrix, int row, int col, int previousValue, int path, int[][] memo) {
        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
            return path;
        }
        
        if(previousValue >= matrix[row][col])
            return path;
        
        if(memo[row][col] == -1) {
           
            int left = longestIncreasingPath(matrix, row, col - 1, matrix[row][col], path, memo);
            int right = longestIncreasingPath(matrix, row, col + 1, matrix[row][col], path, memo);
            int up = longestIncreasingPath(matrix, row - 1, col, matrix[row][col], path, memo);
            int down = longestIncreasingPath(matrix, row + 1, col, matrix[row][col], path, memo);

            int max = Math.max(left, right);
            max = Math.max(max, down);
            max = Math.max(max, up);
            memo[row][col] = max;
        }
        
        return memo[row][col] + 1;
    }
}