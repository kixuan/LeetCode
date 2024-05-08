package dp;

/**
 * @author kixuan
 * @version 1.0
 */
public class l416 {
    public boolean canPartition(int[] nums) {
        // 这也是背包问题？先计算总和，然后加起来 = 1/2*sum就行
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1)
            return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
            if (dp[target] == target)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        l416 l416 = new l416();
        System.out.println(l416.canPartition(new int[]{1, 5, 11, 5}));
    }

}
