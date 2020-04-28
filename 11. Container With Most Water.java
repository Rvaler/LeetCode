class Solution {
    public int maxArea(int[] height) {
        
        // brute force approach, T: O(n^2)
        
        // linear approach, start with one index at each end of array, always move the smaller index
        
        int startIndex = 0;
        int endIndex = height.length - 1;
        
        int maxWater = 0;
        
        while(startIndex < endIndex) {
            
            // Calculate heights
            int startHeight = height[startIndex];
            int endHeight = height[endIndex];
            maxWater = Math.max(maxWater, (endIndex - startIndex) * Math.min(startHeight, endHeight));
            
            if(startHeight > endHeight) {
                endIndex--;
            } else {
                startIndex++;
            }
        }
        
        return maxWater;
    }
}