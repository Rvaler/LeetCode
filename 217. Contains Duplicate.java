class Solution {
    public boolean containsDuplicate(int[] nums) {
        // O(n^2) time complexity for a brute force approach
        
        // O(n logn) sort array and then check for duplicate values adjacents
        
        // O(n) time and space complexity
        
        Set<Integer> s = new HashSet<Integer>();
        for(int num: nums) {
            Integer iNum = new Integer(num);
            if(s.contains(iNum))
                return true;
            
            s.add(iNum);
        }
        
        return false;
    }
}