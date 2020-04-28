class Solution {
    
    // s = "1aB23"
    // output = ["1aB23", "1ab23", "1AB23", "1ab23"]
    
    // O(2^n), where n is the length of my word: Time complexity
    // O(n), space complexity
    
    public List<String> letterCasePermutation(String S) {
        ArrayList<String> stringTransformations = new ArrayList<>();
        
        char[] charArray = S.toCharArray();
        
        // charArray[0] = Character.toUpperCase(charArray[0]);
        
        createTransformations(charArray, stringTransformations, 0);
        
        return stringTransformations;
    }
    
    public void createTransformations(char[] word, ArrayList<String> ways, int index) {
        if(index >= word.length) {
            ways.add(String.copyValueOf(word));
            return;
        }

        if(word[index] >= 'A' && word[index] <= 'Z') { 
            // letter is uppercase
            createTransformations(word, ways, index + 1); // dont change
            word[index] = Character.toLowerCase(word[index]); // change letter to lowercase
            createTransformations(word, ways, index + 1);
        } else if(word[index] >= 'a' && word[index] <= 'z') { 
            // letter is lowercase
            createTransformations(word, ways, index + 1); // dont change
            word[index] = Character.toUpperCase(word[index]); // change letter to uppercase
            createTransformations(word, ways, index + 1);
        } else { 
            // char is not a letter
            createTransformations(word, ways, index + 1);
        }
    }
    
}