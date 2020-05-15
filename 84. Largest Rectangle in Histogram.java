class Solution {
    
    // O(n^2) brute force approach
//     public int largestRectangleArea(int[] heights) {
        
//         if(heights.length == 1)
//             return heights[0];
        
//         int maxArea = 0;
        
//         for(int i = 0; i < heights.length; i++) {
//             int minHeight = heights[i];
//             for(int j = i; j < heights.length; j++) {
//                 minHeight = Math.min(minHeight, heights[j]);
//                 maxArea = Math.max(maxArea, (j - i + 1) * minHeight);
//             }
//         }
        
//         return maxArea;
//     }
    
    
    // Use a stack for O(N) time complexity
    
    // Keep a stack with the indexes of my bars, and from left to right, add to my stack if the current bar is greater or equal to my top of stack.
    // If current bar is smaller, I want to keep removing from top, till my top become smaller or equal to my current
    // Meanwhile, I should calculate the possible areas and compare to a global max
    
    // Space and Time Complexities: O(n)

    public int largestRectangleArea(int[] heights) {
        
        if(heights.length == 1)
            return heights[0];
        
        Stack<Integer> s = new Stack<>();
        int globalMax = 0;
        int index = 0;
        
        while(index <= heights.length) {

            while(!s.isEmpty() && heights[s.peek()] > 
                  ((index == heights.length) ? -1 : heights[index])) {
                int top = s.pop();
                int range = (s.isEmpty()) ? index : index-s.peek()-1;
                int localMax = range*heights[top];
                globalMax = Math.max(globalMax, localMax);
            }
            
            s.add(index);
            index++;
        }
        
        return globalMax;
    }
}