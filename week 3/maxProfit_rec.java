class Solution {

    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1) {
            return 0; 
        }
        return helper(0, Integer.MAX_VALUE, prices);
    }
    
    public int helper(int i, int min, int[] prices) {
        if(i == prices.length -1) {
            return prices[i] - min;
        }
        
        min = Math.min(prices[i], min);
        return Math.max(prices[i] - min, helper(i + 1, min, prices));
    }
    
}