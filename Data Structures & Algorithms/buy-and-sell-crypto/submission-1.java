class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (var price : prices) {
            int profit = price - minPrice;
            if (profit > maxProfit) maxProfit = profit;
            if (minPrice > price) minPrice = price;
        }

        return maxProfit;
    }
}
