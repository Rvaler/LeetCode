class Solution {
    
    // Have a pointer at my beggining and at my end
    // Create a new array, and put max of pow of begin and end
    // update my indexes
    
    // Time complexity: O(n)
    // Space complexity: O(n)
    
    public int[] sortedSquares(int[] A) {
        
        int sorted[] = new int[A.length];
        int begin = 0;
        int end = A.length - 1;
        
        
        for(int i = A.length - 1; i >= 0; i--) {
            int beginPow = (int)Math.pow(A[begin], 2);
            int endPow = (int)Math.pow(A[end], 2);
            
            if(beginPow > endPow) {
                sorted[i] = beginPow;
                begin++;
            } else {
                sorted[i] = endPow;
                end--;
            }
        }
        
        return sorted;
    }
}