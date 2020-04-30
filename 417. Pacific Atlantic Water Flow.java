class Solution {
    
    // Solution: For each position of matrix, calculate if it can reach the Pacific Ocean, for each one of those, calculate if it can reach the Atlantic Ocean
    // Search in the matrix is done using BFS, and memoization is also used to save some time
    // Space complexity is: O(r*c), which is the number of rows and columns of my matrix
    // Time complexity worst case is: O(r*c)^2
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        if(matrix == null || matrix.length == 0)
            return new ArrayList<>();
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] canReachPacific = new int[rows][cols];
        int[][] canReachAtlantic = new int[rows][cols];
        
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                canReachPacific[row][col] = canReachOcean(matrix, row, col, 0, 0, canReachPacific);
            }
        }
        
        for(int row = rows - 1; row >= 0; row--) {
            for(int col = cols - 1; col >= 0; col--) {
                if(canReachPacific[row][col] == 1) 
                    canReachAtlantic[row][col] = canReachOcean(matrix, row, col, rows - 1, cols - 1, canReachAtlantic);   
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(canReachPacific[row][col] == 1 && canReachAtlantic[row][col] == 1) {
                    ArrayList<Integer> coordinate = new ArrayList<>();
                    coordinate.add(row);
                    coordinate.add(col);
                    result.add(coordinate);
                }
            }
        }
        
        return result;
    }
    
    // BFS Search
    public int canReachOcean(int[][] matrix, int row, int col, int oceanRow, int oceanCol, int[][] canReachOcean) {
        
        int maxCol = matrix[0].length;
        int maxRow = matrix.length;
        
        boolean[][] visited = new boolean[maxRow][maxCol];
        
        visited[row][col] = true;
        
        Queue<Integer> rowQ = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        rowQ.add(row);
        colQ.add(col);
        
        while(!rowQ.isEmpty()) {
            
            int topRow = rowQ.remove();
            int topCol = colQ.remove();
            
            if(topRow == oceanRow || topCol == oceanCol) // reached ocean
                return 1;
            
            // already previously calculated
            if(canReachOcean[row][col] != 0) {
                return canReachOcean[row][col];
            }   
            
            // continue seaching on neighboors
            int[] rowDirections = new int[]{-1, +1, 0, 0};
            int[] colDirections = new int[]{0, 0, +1, -1};
            
            for(int i = 0; i < 4; i++) {
                int nextRow = rowDirections[i] + topRow;
                int nextCol = colDirections[i] + topCol;
                if(nextRow >= 0 && nextRow < maxRow && nextCol >= 0 && nextCol < maxCol 
                   && visited[nextRow][nextCol] == false 
                   && matrix[nextRow][nextCol] <= matrix[topRow][topCol]) {
                    rowQ.add(nextRow);
                    colQ.add(nextCol);
                    visited[nextRow][nextCol] = true;
                }   
            }
        }
        
        return -1;
    }
}