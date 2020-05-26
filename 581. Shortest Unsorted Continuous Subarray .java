class Solution {
    
    // [1, 3, 2, 2]
    
    // [1, 2, 2, 3]
    
    // Sort a copy of the input array, then check for different values, those will be the max and min indexes
    // Time Complexity: O(n*log(n))
    // Space Complexity: O(n)
    
    // [2, 2, 2, 2, 1, 4, 4, 4, 5]
    
    // We could reduce time complexity to O(n), and space complexity to O(1) by from left to right, find first occurence where nums[i] > nums[i + 1]
    // After that, search on left subarray where the nums[i + 1] position should be placed, that will be our start Index.
    // Repeat process from right to left, and find End index
    // 4 loops of O(n) time complexity would be required
    
    public int findUnsortedSubarray(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return 0;
        
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        
        int start = sortedNums.length, end = 0;
        
        for(int i = 0; i < sortedNums.length; i++) {
            if(nums[i] != sortedNums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        
        return end > start ? end - start + 1 : 0;
    }
}