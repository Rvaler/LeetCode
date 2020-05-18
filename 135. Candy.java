class Solution {
    
    // Input: [1,0,2]
    //         2,1,2
    
    // Input: [1,2,2]
    //         1,2,1
    
    // [1, 1, 2, 3, 4, 3, 1, 2, 2]
    //  1, 1, 2, 3, 4, 1, 1, 2, 1 // left to right
    //  1, 1, 1, 1, 3, 2, 1, 1, 1  // right to left
    
    // Solution: iterate from left to right, giving 1 candy to student if previous student has rating greater or equal than current, if previous student has a rating smaller than current, than current receives the same as previous + 1
    // Repeat this from right to left
    // The number of candies will be the maximum of right to left | left to right iterations
    // Time complexity: O(n)
    // Space complexity: O(n)
    
    public int candy(int[] ratings) {
        
        if(ratings == null || ratings.length == 0)
            return 0;
        
        if(ratings.length == 1)
            return 1;
        
        int size = ratings.length;
        
        int candiesLR[] = new int[size];
        int candiesRL[] = new int[size];
        
        // left to right iteration
        candiesLR[0] = ratings[0] > ratings[1] ? 2 : 1;
        for(int i = 1; i < size; i++) {
            if(ratings[i] > ratings[i - 1])
                candiesLR[i] = candiesLR[i - 1] + 1;
            else
                candiesLR[i] = 1;
        }
        
        // right to left
        candiesRL[size - 1] = ratings[size - 1] > ratings[size - 2] ? 2 : 1;
        for(int i = size - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1])
                candiesRL[i] = candiesRL[i + 1] + 1;
            else
                candiesRL[i] = 1;
        }
        
        // count the num of candies
        int numOfCandies = 0;
        for(int i = 0; i < candiesRL.length; i++) 
            numOfCandies += Math.max(candiesRL[i], candiesLR[i]);
        
        return numOfCandies;
    }
}