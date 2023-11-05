package 数组;

/**
 * @author kixuan
 * @version 1.0
 */
public class l209 {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            // 滑动窗口
            // 此时i指向的是末尾位置
            int sum = 0 ;
            int result = nums.length+1;
            for(int i=0;i<nums.length;i++){
                sum += nums[i];
                // 首指针开始往前移动
                if(sum>=target){
                    int j = 0;
                    int tmp = sum;
                    while(tmp>target){
                        tmp-=nums[j++];
                    }
                    result = Math.min(i-j+ 1,result);
                }
            }
            return result==nums.length+1?0:result;
        }
    }

    public static void main(String[] args) {
        l209 l = new l209();
        Solution solution = l.new Solution();
        int[] nums = {1,2,3,4,5};
        System.out.println(solution.minSubArrayLen(11, nums));
    }
}
