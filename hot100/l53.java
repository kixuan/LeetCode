package hot100;

/**
 * @author kixuan
 * @version 1.0
 */
public class l53 {
    public int maxSubArray(int[] nums) {
        int total_sum = 0;
        int temp_sum = 0;
        for (int num : nums) {
            temp_sum += num;
            if (temp_sum < 0) {
                temp_sum = 0;
            } else
                total_sum = Math.max(total_sum, temp_sum);
        }
        total_sum = Math.max(total_sum, 0);
        return total_sum;
    }

    public static void main(String[] args) {
        l53 l53 = new l53();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(l53.maxSubArray(nums));
    }

// 记录最小的
}


