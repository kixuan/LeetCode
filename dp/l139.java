package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kixuan
 * @version 1.0
 */
public class l139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // s是背包，wordDict是物品；物品能否装满背包
        // 定义：dp[j]表示长度为j时，是否可以按顺序拆分在wordDict出现的单词，这就决定了后面必须先背包再物品
        // 递推公式：dp[j]=contains && dp[j];
        boolean[] dp = new boolean[s.length() + 1];
        // 初始化，肯定是true
        dp[0] = true;

        // 可以重复使用 ==》完全背包
        for (int i = 1; i <= s.length(); i++) {
            for (String string : wordDict) {
                // 剪枝，字符长度<当前单词长度就直接跳过
                if (i < string.length() - 1) continue;
                if (s.startsWith(string, i - string.length()) && dp[i - string.length()]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        l139 l139 = new l139();
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(l139.wordBreak("leetcode", list));
    }
}
