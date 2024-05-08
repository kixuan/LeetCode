package 数组;


/**
 * @author kixuan
 * @version 1.0
 */
public class l283 {
    public void moveZeroes(int[] nums) {
        int end = nums.length - 1;
        for (int i = 0; i <= end; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < end; j++) {
                    nums[j] = nums[j + 1];
                }
                i--;
                nums[end] = 0;
                end--;
            }
        }
    }

    public void main() {
        l283 l = new l283();
        int[] nums = {0, 0, 1};
        l.moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
