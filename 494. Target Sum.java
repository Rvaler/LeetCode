class Solution {

    public int findTargetSumWays(int[] nums, int S) {
        
        Map<String, Integer> map = new HashMap<>();
        
        return findTargetSumWays(nums, S, 0, 0, map);
    }
    
    public int findTargetSumWays(int[] nums, int S, int sum, int index, Map<String, Integer> map) {
        
        if(index == nums.length) { // reached to the end
            return S == sum ? 1 : 0;
        }
        
        String key = sum + "|" + index;
        
        if (map.get(key) == null) {
            int pos = findTargetSumWays(nums, S, sum + nums[index], index + 1, map);
            int neg = findTargetSumWays(nums, S, sum - nums[index], index + 1, map);
            
            map.put(key, neg + pos);
        }
        
        return map.get(key);
    }
}