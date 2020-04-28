class Solution {
    public void setZeroes(int[][] matrix) {
        // N x M matrix
        // Time complexity: O(n*m), space complexity: O(n + m)
        int cols = matrix[0].length;
        int rows = matrix.length;
        
        // boolean[] zeroCols = new boolean[cols];
        // boolean[] zeroRows = new boolean[rows];
        
//         // Checking each position to discover zero cols and rows
//         for(int row = 0; row < rows; row++) {
//             for(int col = 0; col < cols; col++) {
//                 if(matrix[row][col] == 0) {
//                     zeroCols[col] = true;
//                     zeroRows[row] = true;
//                 }
//             }
//         }
        
//         // Zeroing rows
//         for(int row = 0; row < rows; row++) {
//             if(zeroRows[row] == true) { // Should zero entire matrix at specific row
//                 for(int col = 0; col < cols; col++)
//                     matrix[row][col] = 0;
//             }
//         }
        
//         // Zeroing cols
//         for(int col = 0; col < cols; col++) {
//             if(zeroCols[col] == true) { // Should zero entire matrix at specific col
//                 for(int row = 0; row < rows; row++)
//                     matrix[row][col] = 0;
//             }
//         }
        
        // Optimal Solution uses Space Complexity: O(1), time complexity O(n*m)
        // use first col and row to keep the zero cols and rows
        
        boolean firstRowContainsZero = false;
        boolean firstColContainsZero = false;
        for(int row = 0; row < rows; row++) {
            if(matrix[row][0] == 0) {
                firstColContainsZero = true; break;
            }
        }
        for(int col = 0; col < cols; col++) {
            if(matrix[0][col] == 0) {
                firstRowContainsZero = true; break;
            }
        }
                
        
        // Checking each position to discover zero cols and rows
        for(int row = 1; row < rows; row++) {
            for(int col = 1; col < cols; col++) {
                if(matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
        
        // Zeroing matrix besides 1st column and row
        for(int row = 1; row < rows; row++) {
            for(int col = 1; col < cols; col++) {
                if(matrix[0][col] == 0 || matrix[row][0] == 0)
                    matrix[row][col] = 0;
            }
        }
        
        // Zero 1st col and 1st row if needed
        if(firstRowContainsZero) {
            for(int col = 0; col < cols; col++)
                matrix[0][col] = 0;
        }
        if(firstColContainsZero) {
            for(int row = 0; row < rows; row++)
                matrix[row][0] = 0;
        }
    }
}