package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kixuan
 * @version 1.0
 */
public class l17 {
    // AbstractQueuedSynchronizer
    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return list;

        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, numString, 0);
        return list;
    }

    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuilder
    StringBuilder temp = new StringBuilder();

    public void backTracking(String digits, String[] numString, int num) {
        if (num == digits.length()) {
            list.add(temp.toString());
            return;
        }

        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backTracking(digits, numString, num + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        l17 l17 = new l17();
        List<String> strings = l17.letterCombinations("23");
        System.out.println(strings);
    }
}
