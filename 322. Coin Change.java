class Solution {
    
    // Dynamic Programming Top Down Approach
    public int coinChange(int[] coins, int amount) {
        
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, 0);
        
        int result = coinChanges(coins, amount, memo);
        
        // for(int n: memo) {
        //     System.out.print(n + " ");
        // }
        return result;
    }
    
    public int coinChanges(int[] coins, int amount, int[] memo) {
        if(amount < 0)
            return -1;
        
        if(amount == 0)
            return 0;
        
        if(memo[amount] != 0)
            return memo[amount];
        
        int min = 9999999;
        for(int coin: coins) {
            int res = coinChanges(coins, amount - coin, memo);
            if(res >= 0 && res < min)
                min = 1 + res;
        }
        memo[amount] = min == 9999999 ? -1 : min;
        return memo[amount];
    }
}

// Bottom Up Dynamic Programming solution
// class Solution {
//     public int coinChange(int[] coins, int amount) {
        
//         int[] memo = new int[amount + 1];
//         Arrays.fill(memo, -1);
        
//         memo[0] = 0;
//         for(int coin: coins)
//             if(coin < memo.length)
//                 memo[coin] = 1;    
        
//         for(int i = 1; i <= amount; i++) {
//             int minCoin = 9999999;
//             for(int coin: coins) {
//                 if(i - coin >= 0 && memo[i - coin] >= 0) {
//                     minCoin = Math.min(memo[i - coin] + 1, minCoin);
//                 }
//             }
//             memo[i] = minCoin != 9999999 ? minCoin : -1;
//         }
        
//         return memo[amount];

//     }
// }