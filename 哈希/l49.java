package 哈希;

import java.util.*;

class l49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 1. 确定返回值
        // 2. 查找重复用hashset
        // 3. 排序确定唯一性
        Map<String, List<String>> hashmap = new HashMap<>();
        for (String str : strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String key = new String(s);
            // 为什么这里用 computeIfAbsent 而不用 putIfAbsent
            // computeIfAbsent 的核心在于它能根据需要动态创建并返回一个新的值，而 putIfAbsent 只能直接插入给定的值
            // computeIfAbsent 可以根据 key 的存在与否来决定是否要创建一个新的值，而 putIfAbsent 只能直接插入给定的值
            // computeIfAbsent 能 new，但 putIfAbsent 只能 put
            hashmap.computeIfAbsent(key, value -> new ArrayList<>()).add(str);
            // 使用其他方法实现：getOrDefault
            List<String> list = hashmap.getOrDefault(key, new ArrayList<>());
            list.add(str);
            hashmap.put(key, list);
        }
        return new ArrayList<>(hashmap.values());
    }
}