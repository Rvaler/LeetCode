class Solution {
    public int climbStairs(int n) {
        // n = 3 => 2, 1; 1, 2; 1, 1, 1
        // n = 0; 1
        
        int[] memo = new int[n + 1];
        for(int i = 0; i < memo.length; i++)
            memo[i] = -1;
        
        return climbStairs(n, memo);
    }
    
    public int climbStairs(int n, int[] memo) {
        if(n < 0)
            return 0;
        
        if(n == 0)
            return 1;
        
        if(memo[n] == -1) {
            memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
        }
        
        return memo[n];
    }
}