
// 121. Best Time to Buy and Sell Stock
// You are given an array prices where prices[i] is the price of a given stock on the ith day.You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

public class MaxProfit {
    public static int maxProfit(int[] prices) {
           int maxProfit = 0;
           int bestBuy = prices[0];  // // Set to max initially

          for (int i = 1; i < prices.length; i++) {
            if( prices[i] > bestBuy ) {
                maxProfit = Math.max(maxProfit, prices[i] - bestBuy);  // // Compute max profit
            }
             bestBuy = Math.min(bestBuy, prices[i]);  // // Track lowest price so far
          }
          return maxProfit;   // // If values are decreasing, maxProfit remains 0
    }     

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3 , 8, 4};
        System.out.println("Max Profit: " + maxProfit(prices));
    }
}