class Solution {
    
    // Input: nums = [2,3,1,0,4]
    // currentIndex = 4
    // destination = 4
    
    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length]; // 0: not yet calculated, -1: false, 1: true
        Arrays.fill(memo, 0);
        return canJump(nums, 0, memo);
    }
    
    public boolean canJump(int[] nums, int index, int[] memo) {
        if(index == nums.length - 1) // reached final destination
            return true;
        
        if(index >= nums.length) // out of bounds
            return false;
        
        if(memo[index] == 0) {
            boolean tryJumps = false;
            for(int i = 1; i <= nums[index]; i++) { // try all different jumps
                tryJumps = tryJumps || canJump(nums, index + i, memo);
            }
            memo[index] = tryJumps == false ? -1 : 1;
        }
        
        return memo[index] == -1 ? false : true;
    }
}