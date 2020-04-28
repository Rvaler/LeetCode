class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ways = new ArrayList<String>();
        
        generateParenthesis(ways, n, n, new StringBuilder());
        
        return ways;
    }
    
    public void generateParenthesis(List<String> ways, int openParenthesisRemaining, int closeParenthesisRemaining, StringBuilder s) {
        
        // reached to end of string construction
        if(openParenthesisRemaining == 0 && closeParenthesisRemaining == 0) {
            ways.add(s.toString());
            return;
        }

        // cut invalid solutions
        if(openParenthesisRemaining > closeParenthesisRemaining)
            return;
        
        // trying solution opening a parenthesis
        if(openParenthesisRemaining > 0) {
            s.append("(");
            generateParenthesis(ways, openParenthesisRemaining - 1, closeParenthesisRemaining, s);
            s.setLength(s.length() - 1);
        }
        
        // trying solution closing a parenthesis
        if(closeParenthesisRemaining > 0) {
            s.append(")");
            generateParenthesis(ways, openParenthesisRemaining, closeParenthesisRemaining - 1, s);
            s.setLength(s.length() - 1);
        }
    }
}