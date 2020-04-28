class Solution {
    public int rob(int[] nums) {
        // for each house I can choose to rob or not rob
        // constraint: two adjacent houses cannot be robbed at the same night
        // [i]: 1) rob i and advance 2 positions. 2) not rob i and advance 1 position
        
        // O(2^n) time complexity, possibly use DP to improve latter
        // Reduced time complexity to n with DP
        
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        
        return rob(nums, 0, memo);
        
    }
    
    public int rob(int[] nums, int index, int[] memo) {
        if(index >= nums.length) {
            return 0;
        }
        
        if(memo[index] != -1) {
            return memo[index];
        }
        
        int robHouse = nums[index] + rob(nums, index + 2, memo); // Option 1
        int notRobHouse =  rob(nums, index + 1, memo); // Option 2
        memo[index] = Math.max(robHouse, notRobHouse);
        
        return memo[index];
    }
}