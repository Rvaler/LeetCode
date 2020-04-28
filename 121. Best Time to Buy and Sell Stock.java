class Solution {
    public int maxProfit(int[] prices) {
        // Minimun input size is 2 prices
        if(prices.length < 2)
            return 0;
        
        int minBuy = prices[0];
        int maxSell = prices[1];
        
        int maxProfit = maxSell - minBuy;
        
        for(int i = 1; i < prices.length; i++) {
            
            if(prices [i] < minBuy) {
                maxSell = 0;
                minBuy = prices[i];
            } else if(prices[i] > maxSell) {
                maxSell = prices[i];
            }
            
            maxProfit = Math.max(maxProfit, maxSell - minBuy);
        }
        
        return maxProfit > 0 ? maxProfit : 0;
    }
}