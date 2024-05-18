package dp;

/**
 * @author kixuan
 * @version 1.0
 */
public class l213 {
    public int rob(int[] nums) {
        // 三种情况
        // 情况1:选头；情况2：选尾；情况3：选中间
        int len = nums.length;
        if (len == 1)
            return nums[0];

        // dp[j]：第j间房时的最高金额
        int[] dp = new int[len];
        // 情况1+2
        if (nums[0] >= nums[len - 1]) {
            dp[0] = nums[0];
            len--;
        } else dp[0] = nums[len - 1];
        dp[1] = Math.max(nums[0], nums[1]);

        // 当前状态依赖于前面的状态
        // dp[i-1]选了，这次就不能选
        // dp[i-2]没选，这就就可以选，再取最大值
        // 一次for就好
        for (int j = 2; j < len; j++) {
            dp[j] = Math.max(dp[j - 1], dp[j - 2] + nums[j]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        l213 l213 = new l213();
        System.out.println(l213.rob(new int[]{1, 2, 3}));
    }
}
