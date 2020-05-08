class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // Solution
        // create a hashmap of <letter, index>
        // keep the last index valid for my substring
        // iterate through string and:
            // if not repeated, add to the hashmap 
            // if repeated, update index of character, and update last valid index
        
        // Time Complexity: O(s)
        // Space Complexity: O(s)
        
        HashMap<Character, Integer> map = new HashMap<>();
        int lastValidIndex = 0;
        int longestSubstringSize = 0;
        
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(map.get(c) != null) { // contains
                lastValidIndex = Math.max(lastValidIndex, map.get(c) + 1);
                map.put(c, i);
            } else {
                map.put(c, i);
            }
            
            longestSubstringSize = Math.max(longestSubstringSize, i - lastValidIndex + 1);
        }
        
        return longestSubstringSize;
    }
    
}