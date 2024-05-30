package backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kixuan
 * @version 1.0
 */
public class l216 {
    // 服了烙铁，这个定义就可以biu穿我了
    List<List<Integer>> result = new ArrayList<>(); // 存放结果集合
    LinkedList<Integer> path = new LinkedList<>(); // 存放单个组合结果
    int sum = 0; // 当前路径上的数值和

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n, k, 1);
        return result;
    }

    public void backtracking(int targetSum, int k, int startIndex) {
        // 剪枝：如果当前和已经大于目标和，则直接返回
        if (sum > targetSum)
            return;
        // 如果路径长度达到k并且和等于目标和，则找到一个组合
        if (path.size() == k) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        // 控制树的横向遍历
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i); // 处理当前节点
            sum += i; // 更新当前和
            backtracking(targetSum, k, i + 1); // 递归：控制树的纵向遍历，下一层搜索从i+1开始
            sum -= i; // 回溯：撤销处理节点
            path.removeLast(); // 回溯：移除当前节点
        }
    }

    public static void main(String[] args) {
        l216 l216 = new l216();
        List<List<Integer>> lists = l216.combinationSum3(3, 9);
        System.out.println(lists);
    }
}
