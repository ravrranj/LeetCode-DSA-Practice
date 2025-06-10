
public class Solution {
    public int maxProfit(int[] price) {
    
        int maxProfit = 0;
        int bestBuy = price[0];

        for(int i = 0; i < price.length; i++) {


            if (price [i] > bestBuy) {
                maxProfit = Math.max(maxProfit, price[i] - bestBuy);
            }

            bestBuy = Math.min(bestBuy, price[i]);
        }

        return maxProfit;

    }
}