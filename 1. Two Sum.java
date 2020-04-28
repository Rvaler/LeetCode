class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // O(n log(n)) solution, order array first and then interact
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        
        while(nums[start] + nums[end] != target && start < end) {
            int sum = nums[start] + nums[end];
            
            if(sum > target) {
                end--;
            } else {
                start++;
            }
        }
        
        int[] result = new int[2];
        result[0] = start;
        result[1] = end;
        return result;
        
        // int result[] = new int[2];
        // // O(n^2) solution, brute force
        // for(int i = 0; i < nums.length - 1; i++) {
        //     for(int j = i + 1; j < nums.length; j++) {
        //         if(nums[i] + nums[j] == target) {
        //             result[0] = i;
        //             result[1] = j;
        //             return result;
        //         }
        //     }
        // }
        // return result;
    }
}