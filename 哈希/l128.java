package 哈希;

import java.util.*;

/**
 * @author kixuan
 */
public class l128 {

    // 1. 用hashset
    public int longestConsecutive(int[] nums) {
        // 1. 直接排序，找递增 ==》有重复的，用hashset去重
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        // 排序，计算最长长度
        int longest = 0;
        for (int num : nums) {
            int curNum = num;
            int curStreak = 1;
            // 剪枝条件：如果找到了比当前值小1的值，那么就不用再找了，因为到时候也会找到这个值
            // 如果不剪枝的话会超时
            if (!set.contains(curNum - 1)) {
                // 往后找
                while (set.contains(curNum + 1)) {
                    curNum += 1;
                    curStreak += 1;
                }
                longest = Math.max(longest, curStreak);
            }
        }
        return longest;
    }

    // 2. 用hashmap
    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 2. 创建一个 HashMap 用于存储每个数字及其对应的连续序列长度
        Map<Integer, Integer> map = new HashMap<>();
        // 3. 用于保存最长的连续序列长度
        int res = 1;

        // 4. 将数组中的每个元素插入 HashMap，并初始化其连续序列长度为 1
        for (int i : nums) {
            map.put(i, 1);
        }
        // 5. 对数组进行排序，确保数组按递增顺序进行遍历
        Arrays.sort(nums);

        // 6. 遍历排序后的数组，寻找最长的连续序列
        for (int i : nums) {
            // 7. 检查当前数字的前一个数字 (i - 1) 是否存在于 HashMap 中
            if (map.containsKey(i - 1)) {
                // 8. 如果存在，则获取前一个数字的连续序列长度，加 1 得到当前数字的序列长度
                int p = map.get(i - 1) + 1;
                // 9. 更新结果变量，保存当前的最长连续序列长度
                res = Math.max(p, res);
                // 10. 更新当前数字的序列长度到 HashMap 中
                map.put(i, p);
            }
        }
        return res;
    }
}
