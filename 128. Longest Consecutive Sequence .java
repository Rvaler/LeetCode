class Solution {
    
    // Solution complexity: Time and Space: O(n)
    // Create set of elements in my array
    // iterate over elements checking if adjacent numbers exist
    
        
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for(int n: nums) 
            numsSet.add(n);
        
        int maxConsecutive = 0;
        
        while(!numsSet.isEmpty()) {
            int currentConsecutive = 1;
            
            Integer n = numsSet.iterator().next();
            numsSet.remove(n);
            
            // look for greater nums
            int up = n + 1;
            while(numsSet.contains(up)) {
                currentConsecutive++;
                numsSet.remove(up);
                up++;
            }
            
            // look for smaller nums
            int down = n - 1;
            while(numsSet.contains(down)) {
                currentConsecutive++;
                numsSet.remove(down);
                down--;
            }
            
            maxConsecutive = Math.max(maxConsecutive, currentConsecutive);
        }
        
        return maxConsecutive;
    }
}