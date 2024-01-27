package 贪心;

/**
 * @author kixuan
 * @version 1.0
 */
public class l55 {
    public boolean canJump(int[] nums) {
        // v1.0
        // 思路：从后开始遍历，到最后一个位置的距离依次+1
        // 如果此时数组值 ＞ 可以跳过去的距离，即ture
        // 但是还要考虑为0的情况\U0001f914
        // int cnt = 1;
        // for(int i=nums.length-2; i>0; i--){
        //     if(nums[i]>=cnt++)
        //         return true;
        // }
        // return false;

        // v2.0
        // 从头开始遍历，更新能够到达的最远位置
        int maxReach =0 ;
        for (int i = 0; i < nums.length; i++) {
            if(i > maxReach) return false;
            maxReach =Math.max(maxReach , i+nums[i]);
        }
        return true;
    }
}
