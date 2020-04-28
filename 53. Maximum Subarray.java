class Solution {
    public int maxSubArray(int[] nums) {
        // O(n^2) brute force solution, 2 inner loops
        
        // O(n) time and space approach using DP
        int[] maxSoFar = new int[nums.length];
        int maxSum = nums[0];
        maxSoFar[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            maxSoFar[i] = Math.max(nums[i], maxSoFar[i - 1] + nums[i]);
            maxSum = Math.max(maxSum, maxSoFar[i]);
        }
        
        return maxSum;
    }
}