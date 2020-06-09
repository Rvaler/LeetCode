class Solution {
    
    // Given nums = [3,2,2,3], val = 3,
    
    // Solution involves to keep two indexes
    // Fast one will iterate searching for values different from the val we want to remove
    // Slow one will stay in the last valid position
    
    // Time complexity: O(n)
    // Space complexity: O(1)
    
    public int removeElement(int[] nums, int val) {
        
        if(nums == null || nums.length == 0)
            return 0;
        
        int slowIndex = 0;
        int fastIndex = 0;
        
        while(fastIndex < nums.length) {
            int currentVal = nums[fastIndex];
            
            // we should ignore this position
            if(currentVal == val) { 
                fastIndex++;
            } else {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
                fastIndex++;
            }
        }
        
        return slowIndex;
    }
}