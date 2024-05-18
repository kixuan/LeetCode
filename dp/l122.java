package dp;

/**
 * @author kixuan
 * @version 1.0
 */
public class l122 {
    public int maxProfit(int[] prices) {
        // dp[i][0]代表第i天持有股票的最大收益
        // dp[i][1]代表第i天不持有股票的最大收益
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            // 持有股票 -- ①当天购入；②之前购入
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            // 不持有股票 -- ①当天卖出；②之前没购入
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[len - 1][1];
    }

    public static void main(String[] args) {
        l122 solution = new l122();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices));
    }
}
