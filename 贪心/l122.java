package 贪心;

/**
 * @author kixuan
 * @version 1.0
 */
public class l122 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++)
            // 算每天的利润，只加每天利润>0的利润
            sum += Math.max(prices[i] - prices[i - 1], 0);
        return sum;
    }
}
