package hot100;

/**
 * @author kixuan
 * @version 1.0
 */
public class l376 {
    public int wiggleMaxLength(int[] nums) {
        int count = 0;   // 记录变化次数
        int direction = 0;  // 记录方向

        for (int i = 1; i < nums.length; i++) {
            int status = nums[i] - nums[i - 1];
            if (status > 0 && direction == 0) {  // 现在处于上升 + 上一次是下降
                direction = 1;  // 把方向改为上升
                count += 1;
            } else if (status < 0 && direction == 1) { // 现在处于下降 + 上一次是上升
                direction = 0;
                count += 1;
            }
        }
        return count + 1;  //序列长度 = 变化次数+1
    }

    public static void main(String[] args) {
        l376 l376 = new l376();
        int[] nums = {3, 3, 3, 2, 5};
        System.out.println(l376.wiggleMaxLength(nums));
    }
}
