package 数组;

/**
 * @author kixuan
 * @version 1.0
 */
public class l977_2 {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        int cnt = ans.length-1;
        while(right >= left){
            if(Math.abs(right)>Math.abs(left)){
                ans[cnt] = nums[right] * nums[right];
                cnt--;
                right--;
            } else {
                ans[cnt] = nums[left] * nums[left];
                cnt--;
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        l977_2 l977 = new l977_2();
        int[] nums = {-4, -1, 0, 3, 10};
        int[] result = l977.sortedSquares(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
