class Solution {
    public int rob(int[] nums) {
        
        // 2 options for house [i]: 
        // 1) rob i and advance 2 positions
        // 2) not roub i and advance 1 position
        
        // 4, 1, 3, 6
        // return rob(nums, 0, false);
        
        // O(2^n) time complexity, since every call can go up to 2 recursive calls
        // 0 -> 1, 2
        // 1 -> 2, 3
        // 2--> 3, 4
        // We can possibly improve time complexity using Dynammic Programming
        
        
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        
        int[][] memo = new int[2][nums.length];
        for(int i = 0; i < memo.length; i++) {
            for(int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        
        return Math.max(rob(nums, 1, 0, memo), nums[0]+ rob(nums, 2, 1, memo));
        
        
//         int numsLength = nums.length;
//         if(numsLength == 0)
//             return 0;
//         if(numsLength == 1)
//             return nums[0];
//         if(numsLength == 2)
//             return Math.max(nums[0], nums[1]);
        
//         // Bottom-up Approach
//         int memo[] = new int[nums.length];
//         memo[0] = nums[0];
//         memo[1] = nums[1];
//         for(int i = 2; i < nums.length; i++) {
//             int option1 = (i != nums.length - 1) ? memo[i - 2] + nums[i] : memo[i - 1];
//             int option2 = memo[i - 1];
//             memo[i] = Math.max(option1, option2);
//         }
        
//         return memo[nums.length - 1];
    }
    
    // flag 0 stands for not robbed 1st house, 1 stands for have robbed 1st
    public int rob(int[] nums, int index, int flag, int[][] memo) {
        if(index >= nums.length) // out of bounds
            return 0;
        
        if(memo[flag][index] != -1)
            return memo[flag][index];
        
        if(index == nums.length - 1)
            return flag == 1 ? 0 : nums[index];
        
        int option1 = nums[index] + rob(nums, index + 2, flag, memo);
        int option2 = rob(nums, index + 1, flag, memo);
        
        memo[flag][index] = Math.max(option1, option2);
        
        return memo[flag][index];
    }
}