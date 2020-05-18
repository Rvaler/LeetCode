class Solution {
    
    // Solution involves to recursively try all permutations and backtrack cutting invalid solutions
    
    // Time Complexity: O(2^s)
    // Space Complexity: O(s), due to recursive calls
    
    public List<String> restoreIpAddresses(String s) {
        
        List<String> possibleIps = new ArrayList<>();
        
        if(s == null || s.isEmpty())
            return possibleIps;
        
        generateIpAddresses("", "", s, 0, possibleIps);
        return possibleIps;
    }
    
    public void generateIpAddresses(String fullIp, String current, String remaining, int parts, List<String> possibleIps) {
        
        if(!isInBounds(current)) // current is greater than 255
            return;
        
        if(parts >= 4) // ip cant have more than 4 parts
            return;
        
        // if(remaining.length() / (4 - parts) > 3) // too many digits left
        //     return;
        
        if(remaining.length() == 0) {
            if(!current.isEmpty()) {
                parts++;
                fullIp += "." + current;
            }
                
            if(parts != 4)
                return;
            
            possibleIps.add(fullIp);
            return;
        }
        
        // 1 solution
        generateIpAddresses(fullIp, current + remaining.substring(0, 1), remaining.substring(1), parts, possibleIps);
        
        // 2 solution
        if(!current.isEmpty()) {
            if(!fullIp.isEmpty()) 
                generateIpAddresses(fullIp + "." + current, 
                                    "", remaining, parts + 1, possibleIps);
            else
                generateIpAddresses(current, "", remaining, parts + 1, possibleIps);    
        }
    }
    
    boolean isInBounds(String s) {
        
        if(s == null)
            return false;
        
        if(s.isEmpty())
            return true;
        
        Integer value = Integer.valueOf(s);
        
        if(value == 0 && s.length() > 1)
            return false;
        
        if(value > 0 && s.charAt(0) == '0')
            return false;
        
        return value >= 0 && value <= 255;
    }
}