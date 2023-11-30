package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kixuan
 * @version 1.0
 */
public class l15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for(int i= 0;i<nums.length;i++){
            // 特判1：第一个元素就＞0
            if(nums[i]>0) return lists;
            // 特判2：
            if(i>0&&nums[i]==nums[i-1]) continue;

            int curr = nums[i];
            int L = i+1,R=nums.length-1;
            while(L<R){
                int temp = curr + nums[L] + nums[R];
                if(temp == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while(L<R&&nums[L+1]==nums[L])++L;
                    while(L<R&&nums[R-1]==nums[R])--R;
                    ++L;
                    --R;
                }
                else if(temp<0) ++L;
                else --R;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        l15 l15 = new l15();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(l15.threeSum(nums));
    }
}
