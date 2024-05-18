package dp;

import java.util.Arrays;

/**
 * @author kixuan
 * @version 1.0
 */
public class l300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                // res = Math.max(res, dp[i]);
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        l300 solution = new l300();
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(solution.lengthOfLIS(nums));
    }
}
