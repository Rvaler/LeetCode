class Solution {
    
    // Constraints
    // 1 is land
    // 0 is water
    
    // Solution
    // 1) Search in my grid for a land position 
    // 2) Explore this island and change all its positions to water
    
    // O(n*m) time and space complexity, where n: num of rows, m: num of cols
    
    
    public int numIslands(char[][] grid) {
        
        int numberOfIslands = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                
                if(grid[row][col] == '1') { 
                    // Explore island and change all land positions to water
                    exploreIsland(grid, row, col);
                    numberOfIslands++;
                }
            }
        }
        
        return numberOfIslands;
    }
    
    public void exploreIsland(char[][] grid, int row, int col) {
        if(row >= grid.length || row < 0 || col >= grid[0].length || col < 0)
            return;
        
        if(grid[row][col] == '0') // reached water
            return;
        
        // continue exploring
        grid[row][col] = '0';
        exploreIsland(grid, row + 1, col);
        exploreIsland(grid, row - 1, col);
        exploreIsland(grid, row, col + 1);
        exploreIsland(grid, row, col - 1);
    }
}