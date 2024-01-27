package 贪心;

/**
 * @author kixuan
 * @version 1.0
 */
public class l53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 总体思路就是：1. 从头开始遍历找最大的和
        // 如果目前的子数列和cnt < 0，这一段都不要，从目前遍历到的下一个元素重新开始找子数列
        // 局部最优 -- 整体最优
        int cnt = 0;

        // 因为是要找最大的和，所以只要记录sum_max就可以了
        // 从-1开始是为了解决出现都为负数的情况
        int sum_max = -1;
        for (int num : nums) {
            cnt += num;
            sum_max = Math.max(cnt, sum_max);
            if (cnt < 0) cnt = 0;
        }
        // 如果全是负数，那么sum_max就是-1，否则 +1
        if (sum_max != 0) sum_max++;
        return sum_max;
    }

    public static void main(String[] args) {
        l53 l = new l53();
        int[] nums1 = {5, 4, -3, -2, 2};
        int[] nums2 = {5, 4, -3, -2, 12};
        System.out.println(l.maxSubArray(nums1));
        System.out.println(l.maxSubArray(nums2));
    }
}
