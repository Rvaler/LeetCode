class Solution {
    public int majorityElement(int[] nums) {
        
        // Sort array and take element at middle position
        // Time and space complexity: O(n logn)
        
        // Arrays.sort(nums);
        // return nums[nums.length / 2];
        
        // Count the number of times each element appears, return when this numbers reach more n/2
        
        HashMap<Integer, Integer> countNums = new HashMap<>();
        Integer max = nums.length / 2 + 1;
        
        for(int n: nums) {
            Integer i = new Integer(n);
            if(countNums.get(i) != null) {
                countNums.put(i, countNums.get(i) + 1);
            } else {
                countNums.put(i, 1);
            }
            
            // Check if reached max
            if(countNums.get(i) >= max)
                return i;
        }
        
        return -1;
    }
}