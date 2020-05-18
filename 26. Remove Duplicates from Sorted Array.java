class Solution {
    
    // Given nums = [0,0,1,1,1,2,2,3,3,4],
    // output: 5, [0, 1, 2, 3, 4]
    
    // slow: 2
    // fast: 5
    // originalValue: 2
    // nums: [0,1,2,1,1,2,2,3,3,4],
    
    // Solution involves to keep 2 indexes, 
    // Fast one will iterate searching for new distinct values
    // Slow one will act in a way to position the non duplicate values in the right position
    
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    
    public int removeDuplicates(int[] nums) {
        
        int slow = 0;
        int fast = 0;
        
        while(fast < nums.length) {
            int originalValue = nums[fast];
            nums[slow] = originalValue;
            slow++;
            
            while(fast < nums.length && nums[fast] == originalValue) {
                fast++;    
            }
        }
        
        return slow;
    }
}