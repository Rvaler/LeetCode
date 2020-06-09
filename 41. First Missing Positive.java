class Solution {
    
    // 1st solution:
    // 1) Sort array O(n log(n))
    // 2) Look for value 1, if exists, next index will be 2, 
    // if so, next will be 3... and so on O(n)
    // Space complexity: O(1)
    
    // 2nd solution:
    // 1) Create a hashmap of all positive values in my array
    // 2) Start from 1 and continue checking if value exists on hashmap
    // Time complexity: O(n)
    // Space complexity: O(n)
    
    // 3rd Solution:
    
    // 1) Iterate over array swapping to 1 any element greater than nums.length or less equal than  0
    // 2) Iterate over array again and swap to negative value the indexes found
    // Time complexity: O(n)
    // Space complexity: O(1)
    
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 1;
        
        boolean containsOne = false;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                containsOne = true;
            } else if(nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }
        
        if(!containsOne)
            return 1;
        
        // switch to negative all positions found in array
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            
            if(nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        
        // find first non-negative value
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                return i + 1;
            }
        }
        
        return nums.length + 1;
    }
}