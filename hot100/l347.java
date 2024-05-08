package hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author kixuan
 * @version 1.0
 */
public class l347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k]; // 结果数组
        Map<Integer, Integer> map = new HashMap<>();
        // 统计数组中各元素出现的次数
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        // 使用最小堆来存储元素和次数的映射，堆的大小为k
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue());

        // 将hashmap的每个映射都放入最小堆，如果size>k，弹出堆顶元素【得益于上面的比较器，确保最小堆】
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            minHeap.offer(entry);
        if (minHeap.size() > k)
            minHeap.poll();

        // 取元素
        for (int i = 0; i < k; ++i)
            res[i] = minHeap.poll().getKey();

        return res;
    }

    public static void main(String[] args) {
        l347 l347 = new l347();
        int[] nums = {3, 0, 1, 0};
        int k = 1;
        int[] result = l347.topKFrequent(nums, k);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
