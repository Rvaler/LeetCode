class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Brute force approach: O(n^2) time complexity
        
        // O(n) time complexity, calculate the product of all elements, and for each element at i, divide the total product by nums[i]
        
        // O(n) space and time complexity: first compute the product of all elements to the left and right of a given element
        
        int[] leftProductList = new int[nums.length];
        leftProductList[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            leftProductList[i] = leftProductList[i - 1] * nums[i - 1];
        }
        
        int[] rightProductList = new int[nums.length];
        rightProductList[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            rightProductList[i] = rightProductList[i + 1] * nums[i + 1];
        }
        
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
            result[i] = leftProductList[i] * rightProductList[i];
        
        return result;
    }
}