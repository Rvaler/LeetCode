class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> charStack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            
            // Opening brackets
            if(c == '(' || c == '{' || c == '[') {
                charStack.add(c);    
            } else {
                // Closing brackets
                if(!isCharValid(charStack, c))
                    return false;
            }
        }
        
        return charStack.isEmpty();
    }
    
    private boolean isCharValid(Stack<Character> charStack, char c) {
        
        if(charStack.isEmpty())
            return false;
        
        char topStack = charStack.pop();
        
        return (topStack == '(' && c == ')') ||
            (topStack == '[' && c == ']') || 
            (topStack == '{' && c == '}');
    }
}