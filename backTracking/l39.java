package backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kixuan
 * @version 1.0
 */
public class l39 {
    List<List<Integer>> result = new ArrayList<>(); // 存放结果集合
    LinkedList<Integer> path = new LinkedList<>(); // 存放单个组合结果
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, sum, 0);
        return result;
    }

    public void backtracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target)
            return;
        if (sum == target) {
            // 如果直接add(path)的话，add的是path的引用，也就是都是一样的，最后为空list[]
            result.add(new ArrayList<>(path));
            return;
        }

        // 剪枝：我们在上面判断过一次了，但还是进入到了回溯，这个sum + candidates[i] <= target就是为了剪枝回溯
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, sum, i);// 注意这里不用i+1，意味着可以重复使用
            sum -= candidates[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        l39 l39 = new l39();
        List<List<Integer>> lists = l39.combinationSum(new int[]{8, 7, 4, 3}, 11);
        System.out.println(lists);
    }
}
