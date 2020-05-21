class Solution {

    
    // Solution is to create a HashMap that will maitain the sorted version of the strings to all its anagrams
    // For each received string in my input, sort it and put it into the map.
    
    // Time Complexity: O(n * s*log(s)), where n is the number of words, and s is the size of max word
    // Space Complexity: O(n * s), hashmap could grow to n containing s, if all words are different anagrams
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> mapSortedStringToWords = new HashMap<>();
        
        for(String str: strs) {
            if(str != null) {
                String sortedWord = getSortedWord(str);
                List<String> words = mapSortedStringToWords.get(sortedWord);
                if(words == null)
                    mapSortedStringToWords.put(sortedWord, new ArrayList<>());
                mapSortedStringToWords.get(sortedWord).add(str); 
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: mapSortedStringToWords.entrySet()) {
            result.add(entry.getValue());
        }
        
        return result;
    }
    
    public String getSortedWord(String s) {
        
        char [] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}