class Solution {
    public int maxProduct(int[] nums) {
        
        // Dynamic Programming solution: 
        // O(n) time complexity
        // O(n) space complexity
        
        // O(1) space complexity by using variables instead of array to compute max
        
        if(nums.length == 0)
            return 0;
        
        // int memo[] = new int[nums.length];
        
        int maxSoFar = nums[0];
        int currentMax = nums[0];
        // memo[0] = nums[0];
        // Left to Right O(N)
        for(int i = 1; i < nums.length; i++) {
            currentMax = currentMax == 0 ? nums[i] : currentMax * nums[i];
            maxSoFar = Math.max(maxSoFar, currentMax);
            // memo[i] = memo[i - 1] == 0 ? nums[i] : memo[i - 1] * nums[i];
            // maxSoFar = Math.max(maxSoFar, memo[i]);
        }
        
        // Right to Left O(N)
        maxSoFar = Math.max(maxSoFar, nums[nums.length - 1]);
        currentMax = nums[nums.length - 1];
        // memo[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--) {
            currentMax = currentMax == 0 ? nums[i] : currentMax * nums[i];
            maxSoFar = Math.max(maxSoFar, currentMax);
            // memo[i] = memo[i + 1] == 0 ? nums[i] : memo[i + 1] * nums[i];
            // maxSoFar = Math.max(maxSoFar, memo[i]);
        }
        
        return maxSoFar;
        
        
        // [2, 3, 0, 5, -6, -2, -120, 0, 3, -3]
        // [6, 0, 60, 0, -9]
        
        // [2, 3, 4, -2, -1, 5, 4, 5]
        // Brute-force approach would take O(n^2)
//         int max = Integer.MIN_VALUE;
//         for(int i = 0; i < nums.length; i++) {
//             int currentProduct = 1;
//             for(int j = i; j < nums.length; j++) {
//                 currentProduct = currentProduct * nums[j];
//                 max = Math.max(max, currentProduct);
//             }
//         }
    
    }
}