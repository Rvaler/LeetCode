class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Create boolean array with n positions, interact through nums and mark the nums I find in this boolean array
        // Time and Space complexity: O(n)
        
//         boolean[] foundNums = new boolean[nums.length];
//         for(int n: nums) {
//             foundNums[n - 1] = true;
//         }
        
//         ArrayList<Integer> result = new ArrayList<>();
//         for(int i = 0; i < foundNums.length; i++) {
//             if(!foundNums[i]) {
//                 result.add(new Integer(i + 1));
//             }
//         }
        
//         return result;
        
        // O(n) time complexity and O(1) space complexity
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                int innerIndex = nums[i] - 1;
                while(nums[innerIndex] > 0) {
                    int tempValue = nums[innerIndex];
                    nums[innerIndex] = 0;
                    innerIndex = tempValue - 1;    
                }
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0)
                result.add(new Integer(i + 1));
        }
        
        return result;
    }
}