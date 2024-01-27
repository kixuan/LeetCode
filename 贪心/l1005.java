package 贪心;

import java.util.Arrays;

/**
 * @author kixuan
 * @version 1.0
 */
public class l1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 处理小于0的情况
            while (k > 0 && nums[i] < 0) {
                k--;
                sum -= nums[i];
                i++;
            }
            if (k % 2 == 1) {
                sum -= nums[i];
                k--;
                continue;
            }
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-8,3,-5,-3,-5,-2};
        int k = 6;
        l1005 l = new l1005();
        System.out.println(l.largestSumAfterKNegations(nums, k));
    }
}
