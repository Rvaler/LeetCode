class Solution {
    
    // -4, -1, -1, 0, 1, 2
    
    // Time Complexity: O(n * log n) to sort the array + O(n^2) to check all possibilities
    // Space Complexity: O(n * log n)
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        // List<List<Integer>> result = new ArrayList<>();
        
        HashSet<List<Integer>> result = new HashSet<>();
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 1; i++) {
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while(left < right) {
                
                int sum = nums[i] + nums[left] + nums[right];
                
                if(sum == 0) {
                    List<Integer> list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    
                    left++;
                    right--;
                } else if(sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
            
        }
        
        List<List<Integer>> resultToList = new ArrayList<>(result);
        return resultToList;
    }
}