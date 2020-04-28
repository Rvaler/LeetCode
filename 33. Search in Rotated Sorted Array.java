class Solution {
    public int search(int[] nums, int target) {
        
        // T: (log n), binary search
        
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end) {
            int midIndex = ((end - start) / 2) + start;
            int midValue = nums[midIndex];
            
            if(midValue == target)
                return midIndex;
            
            if(midValue > target) {
                if(nums[end] >= target) {
                    start = midIndex + 1;
                } else {
                    end = midIndex -1;
                }
            } else { // midValue < target
                if(nums[start] <= target) {
                    end = midIndex - 1;
                } else {
                    start = midIndex + 1;
                }
            }
        }
        
        return -1;
        
        
        // Brute force approach, T: O(n)
//         for(int i = 0; i < nums.length; i++) {
//             if(nums[i] == target) {
//                 return i;
//             }
//         }
        
//         return -1;
    }
}