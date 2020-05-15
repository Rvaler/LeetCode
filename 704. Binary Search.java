class Solution {
    
    // Solution: do a binary search
    // Time Complexity: O(log(n))
    // Space Complexity: O(1)
    
    public int search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length - 1;
        
        // standard binary search
        while(start <= end) {
            int middle = ((end - start) / 2) + start;
            
            if(nums[middle] == target) {
                return middle;
            }
            if(nums[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        
        return -1;
    }
}