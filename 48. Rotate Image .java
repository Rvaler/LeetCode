class Solution {
    
    // Simple logic to rotate in-place a matrix by 90 degrees
    // Time Complexity: O(n^2), once that we must iterate over all positions of the matrix once
    // Space Complexity: O(1)
    
    public void rotate(int[][] matrix) {
        
        if(matrix == null)
            return;
        
        int n = matrix.length;
        
        for(int row = 0; row < n / 2; row++) {
            for(int col = row; col < n - row - 1; col++) {
                int aux = matrix[row][col];
                matrix[row][col] = matrix[n - col - 1][row];
                matrix[n - col - 1][row] = matrix[n - row - 1][n - col - 1];
                matrix[n - row - 1][n - col - 1] = matrix[col][n - row - 1];
                matrix[col][n - row - 1] = aux;
            }
        }
        
        return;
    }
}