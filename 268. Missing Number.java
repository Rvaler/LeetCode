class Solution {
    public int missingNumber(int[] nums) {
        // O(n^2) time complexity for brute force approach
        
        // O(n logn) sort and then find missing number
        
        // O(n) time and space complexity
        
        // O(n) time complexity and O(1) space complexity, I could sum the numbers and then subtract from the sum from 1 to n;
        
        int maxNum = nums.length; // size of array indicates the max number expected
        int numsSum = 0;
        
        for(int num: nums) {
            numsSum += num;
        }
        
        
        int oneToNSum = 0;
        for(int i = 0; i <= maxNum; i++) {
            oneToNSum += i;
        }
        
        return oneToNSum - numsSum;
    }
}