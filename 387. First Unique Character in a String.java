class Solution {
    
    // s = "leetcode"
    // output = 0
    
//     s = "loveleetcode",
//     return 2.
    
    // Map <Character, Integer>
    // l: 0
    // e: -1
    // t: 3
    // c: 4
    
    // Solution takes O(s) time and space complexities
    
    public int firstUniqChar(String s) {
        
        HashMap<Character, Integer> mapCharToIndex = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(mapCharToIndex.containsKey(c)) { // c is a duplicated char
                mapCharToIndex.put(c, -1);
            } else {
                mapCharToIndex.put(c, i);
            }
        }
        
        int minIndex = Integer.MAX_VALUE;
        for(Map.Entry<Character, Integer> entry: mapCharToIndex.entrySet()) {
            if(entry.getValue() >= 0)
                minIndex = Math.min(minIndex, entry.getValue());
        }
        
        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }
}