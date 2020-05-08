class Solution {
    
    // [2,3,1,2,4,3]
    /*
    s = 7
    start = 4
    end = 5
    sum = 7
    minRange = 2
    */
    
    // The solution works by creating a window and shifting this window based on 3 cases:
    // 1) if the sum of the window is smaller than my S, shift the end to the right and sum
    // 2) if the sum of the window is greater, check for two cases:
        // 2.1) the end and start are equal, so should move end to right
        // 2.2) the start is smaller than end, so move right my start
    
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int start = 0;
        int end = 0;
        int sum = nums[0];
        
        int minRange = Integer.MAX_VALUE;
        
        while(end < nums.length) {
            
            if(sum < s) { // should move right my end
                end++;
                if(end < nums.length)
                    sum += nums[end];
            } else { // (sum >= s)
                minRange = Math.min(minRange, end - start + 1);
                if(end == start) { // should move right my end
                    end++;
                    if(end < nums.length)
                        sum += nums[end];
                } else { // should move right my start
                    sum -= nums[start];
                    start++;
                }
            }
        }
        
        return minRange == Integer.MAX_VALUE ? 0 : minRange;
    }
}