package marchallange;

public class BestTimeBuySellStockTransactionFee {
    public int maxProfix(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }

        int hold = -prices[0], cash = 0;
        for (int i = 1; i < prices.length;i++) {
            if (cash < hold + prices[i] - fee) {
                cash = hold+prices[i] - fee;
            }
            if (cash - prices[i] > hold) {
                hold = cash - prices[i];
            }
        }
        return cash;
    }
}
