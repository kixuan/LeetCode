package dp;

/**
 * @author kixuan
 * @version 1.0
 */
public class l62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // dp[i][j] 表示达到[i,j]处的路径数
        // 初始化
        dp[0][0] = 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }
        // 遍历顺序：都可以
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        l62 l62 = new l62();
        System.out.println(l62.uniquePaths(3, 2));
    }
}
