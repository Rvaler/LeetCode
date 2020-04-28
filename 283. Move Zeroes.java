class Solution {
    public void moveZeroes(int[] nums) {
        // Start from back to front of array, and bubble 0s to the end of array or til find another 0
        // Time Complextity: O(n^2), Space: O(1)
//         for(int i = nums.length - 1; i >= 0; i--) {
            
//             // Bubble element
//             if(nums[i] == 0) {
//                 for(int j = i; j < nums.length - 1 && nums[j + 1] != 0; j++) {
//                     int temp = nums[j];
//                     nums[j] = nums[j + 1];
//                     nums[j + 1] = temp;
//                 }
//             }
//         }
        
        // 2) Solution: count the number of 0s, meanwhile, move not zero elements that number of idenxes to the front
        // Time complexity: O(n), space complexity: O(1)
        
        int zerosCount = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zerosCount++;
            } else {
                nums[i - zerosCount] = nums[i];
            }
        }
        
        for(int i = nums.length - 1; zerosCount > 0; i--) {
            nums[i] = 0;
            zerosCount--;
        }
    }
}