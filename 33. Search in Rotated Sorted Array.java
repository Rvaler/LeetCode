class Solution {

    // [0,1,2,3,4,5,6,7]
    // [4,5,6,7,0,1,2,3]
    // [1,2,3,4,5,6,7,0]
    
    // Solution involves a binary search looking for the element
    // Time complexity: O(log(n))
    // Space complexity: O(1)
    
    public int search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end) {
            int middle = ((end - start) / 2) + start;
            
            if(nums[middle] == target)
                return middle;
            
            if(nums[start] < nums[end]) { // normal binary search, array is not rotated
                if(nums[middle] > target) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            } else {
                if(nums[middle] < nums[end]) {
                    if(target > nums[middle] && target <= nums[end]) {
                        start = middle + 1;
                    } else {
                        end = middle - 1;
                    }
                    continue;
                }
                
                if(nums[start] < nums[middle]) {
                    if(target >= nums[start] && target < nums[middle]) {
                        end = middle - 1;
                    } else {
                        start = middle + 1;
                    }
                    continue;
                }
                
                // in the case where no number was found (prevent infinite loop)
                start++;
            }
        }
        
        return -1;
    }
}