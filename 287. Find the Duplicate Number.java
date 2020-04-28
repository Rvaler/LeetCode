class Solution {
    public int findDuplicate(int[] nums) {
        // Create a hashset and insert numbers on it til find a number that is already insterted there
        // O(n) time and space complexity
        
//         Set<Integer> set = new HashSet<>();
//         for(int num: nums) {
//             Integer iNum = new Integer(num);
//             if(set.contains(iNum))
//                 return iNum.intValue();
//             set.add(iNum);
//         }
        
//         return -1;
        
        // Think of array as a linked list that has a cycle, since it contains one duplicate
        // Create two pointers, one goes 1 by 1 position, the other goes 2 by 2
        // O(n) time complexity, O(1) space complexity
        
        int slowIndex = 0;
        int fastIndex = 0;
        
        do {
            slowIndex = nums[slowIndex];
            fastIndex = nums[fastIndex];
            fastIndex = nums[fastIndex];
        } while(nums[slowIndex] != nums[fastIndex]);
        
        // When they collide, start with fast index from the beggining, and walk with the 2 indexes 1 pos by 1 pos
        
        fastIndex = 0;
        while(nums[slowIndex] != nums[fastIndex]) {
            slowIndex = nums[slowIndex];
            fastIndex = nums[fastIndex];
        }
        
        return nums[slowIndex];
    }
}