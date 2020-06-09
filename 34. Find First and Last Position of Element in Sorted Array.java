class Solution {
    
    // Input: nums = [5,7,7,8,8,8,10], target = 8
    // Output: [3,4]
    
    // Solution involves to do a binary search to find if target val exists in my array
    // After that we continue the binary search looking for the most right and left indexes with the correponding value
    // Time complexity: O(log(n))
    // Space complexity: O(1)
    
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        
        while(start <= end) {
            int middle = ((end - start) / 2) + start;
            
            if(nums[middle] > target) { // values are on the left
                end = middle - 1;
            } else if(nums[middle] < target) { // values are on the right
                start = middle + 1;
            } else { // found value
                result[0] = mostLeftIndex(nums, target, start, end);
                result[1] = mostRightIndex(nums, target, start, end);
                
                break;
            }
        }
        
        return result;
    }
    
    public int mostLeftIndex(int[] nums, int target, int start, int end) {
        while(start <= end) {
            int middle = ((end - start) / 2) + start;
            
            if(nums[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        
        return start;
    }
    
    public int mostRightIndex(int[] nums, int target, int start, int end) {
        while(start <= end) {
            int middle = ((end - start) / 2) + start;
            
            if(nums[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        
        return end;
    }
}