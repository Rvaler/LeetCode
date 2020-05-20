class Solution {
    
    // Solution using Dynammic Programming
    // Using a matrix, we check if chars representing the start and end of word are equal and reuse the already calculated substring, updating the maxString if greater than previous value
    // Time Complexity: O(n^2)
    // Space Complexity: O(n^2)
    
    public String longestPalindrome(String s) {
        
        if(s == null)
            return null;
        
        boolean memo[][] = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                memo[i][j] = true;
            }
        }
        
        int maxLength = 0;
        String longestString = "";
        
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = s.length() - 1; j >= i; j--) {
                // is going to be true if chars at start and end of word are equal and
                // if the substring removing begin and end chars are also palindrome
                
                boolean isSubstringPalindrome = true;
                if(i < s.length() - 1 && j > 0) {
                    isSubstringPalindrome = memo[i + 1][j - 1];
                }
                
                memo[i][j] = s.charAt(i) == s.charAt(j) && isSubstringPalindrome;
                if(memo[i][j] && (j - i + 1) > maxLength) {
                    maxLength = j - i + 1;
                    longestString = s.substring(i, j + 1);
                }
            }
        }
        
        return longestString;
    }
    
    // Brute force approach
    // Time complexity: O(n^3)
    
//     public String longestPalindrome(String s) {
        
//         int maxLength = 0;
//         String longestPalindrome = "";
        
//         for(int i= 0; i < s.length(); i++) {
//             for(int j = i; j < s.length(); j++) {
//                 String substring = s.substring(i, j + 1);
//                 if(substring.length() > maxLength && isPalindrome(substring)) {
//                     maxLength = j - i;
//                     longestPalindrome = substring;
//                 }
//             }
//         }
        
//         return longestPalindrome;
//     }
    
//     public boolean isPalindrome(String s) {
//         int start = 0;
//         int end = s.length() - 1;
        
//         for(int i = 0; i < s.length() / 2; i++) {
//             if(s.charAt(start + i) != s.charAt(end - i))
//                 return false;
//         }
        
//         return true;
//     }
}