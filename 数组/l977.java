package 数组;

/**
 * @author kixuan
 * @version 1.0
 */
public class l977 {
    public int[] sortedSquares(int[] nums) {
        // 找到正负数分界线
        int index = 0;
        for (; index < nums.length; index++) {
            if (nums[index] >= 0) break;
        }
        // 双指针分别指向分界线两边的数
        int[] result = new int[nums.length];
        int left = index - 1, right = index;
        int point = 0;

        while (left >= 0 || right < nums.length) {
            if (left < 0) {
                result[point++] = nums[right] * nums[right];
                right++;
            } else if (right == nums.length) {
                result[point++] = nums[left] * nums[left];
                left--;
            } else if (-nums[left] > nums[right]) {
                result[point++] = nums[left] * nums[left];
                left--;
            } else {
                result[point++] = nums[right] * nums[right];
                right++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        l977 l977 = new l977();
        int[] nums = {-4, -1, 0, 3, 10};
        int[] result = l977.sortedSquares(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
