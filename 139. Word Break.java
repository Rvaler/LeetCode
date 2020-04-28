class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for(String word: wordDict)
            wordSet.add(word);
        
        HashMap<String, Boolean> map = new HashMap<>();
        
        return wordBreak(s, wordSet, map);
    }
    
    public boolean wordBreak(String s, Set<String> wordSet, HashMap<String, Boolean> map) {
        if(s.isEmpty()) // reamining word is empty, found solution
            return true;
        
        if(map.get(s) != null)
            return map.get(s);
        
        boolean canCreateWordBreak = false;
        for(int i = 0; i <= s.length(); i++) {
            if(wordSet.contains(s.substring(0, i))) {
                canCreateWordBreak = canCreateWordBreak || wordBreak(s.substring(i), wordSet, map);
            }
        }
        
        map.put(s, canCreateWordBreak);
        
        return map.get(s);
    }
}