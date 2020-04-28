class Solution {
    public int singleNumber(int[] nums) {
        // O(n) time and space complexity
//         Set<Integer> s = new HashSet<>();
        
//         for(int n: nums) {
//             if(s.contains(n)) {
//                 s.remove(n);
//             } else {
//                 s.add(n);
//             }
//         }
        
        // set will only contain 1 single element
        // return s.iterator().next().intValue();
        
        // Without extra memory, could do a O(nˆ2) brute force approach, or even a O(nlogn) where I could sort beforehand and then check for missing value
        
        // Optimal Solution: use XOR operation for every number in my array, will result in the only number that appears once
        
        int num = 0;
        for(int n: nums) {
            num = num ^ n;
        }
        return num;
    }
}