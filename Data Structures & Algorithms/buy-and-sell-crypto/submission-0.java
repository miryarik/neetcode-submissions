class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            int diff = prices[i] - minPrice;
            if (profit < diff) profit = diff;
            if (minPrice > prices[i]) minPrice = prices[i];
        }

        return profit;
    }
}
