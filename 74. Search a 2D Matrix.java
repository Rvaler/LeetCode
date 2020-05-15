class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // Solution would involve to do a binary search to find the correspondent row first, by comparing if my target is in between the interval of that row
        // After that, do a binary search on the row
        // Time Complexity: O(log(n) + log(m))
        // Space Complexity: O(1) 
        
        
        int rows = matrix.length;
        if(rows == 0)
            return false; // base case
        int cols = matrix[0].length;
        if(cols == 0)
            return false; // base case
        
        
        // 1 Step) Find the specific row that fits the interval for my target
        int start = 0;
        int end = rows - 1;
        
        int targetRow = -1;
        while(start <= end) {
            int middle = ((end - start) / 2) + start;
            
            // target is in middle row
            if(matrix[middle][0] <= target && matrix[middle][cols - 1] >= target) {
                targetRow = middle;
                break;
            }
            
            if(matrix[middle][0] > target) {
                // search on above rows
                end = middle - 1;
            } else {
                // search on below rows
                start = middle + 1;
            }
        }
        
        // haven't found any row that matches the range of my target
        if(targetRow == -1)
            return false;
        
        // 2 Step) Find the column in the specific row that matches my target value
        start = 0;
        end = cols - 1;
        while(start <= end) {
            int middle = ((end - start) / 2) + start;
            
            if(matrix[targetRow][middle] == target)
                return true;
                
            if(matrix[targetRow][middle] > target) {
                end = middle -1;
            } else {
                start = middle + 1;
            }
        }
        
        return false;
    }
}