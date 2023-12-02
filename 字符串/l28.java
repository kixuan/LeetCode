package 字符串;

/**
 * @author kixuan
 * @version 1.0
 */
public class l28 {
    // public int strStr(String haystack, String needle) {
    //     if (needle.length() > haystack.length()) {
    //         return -1;
    //     }
    //     for (int i = 0; i < haystack.length(); i++) {
    //         int flag = 0;
    //         int temp = i;
    //         for (int j = 0; j < needle.length(); j++) {
    //             while (haystack.charAt(temp) == needle.charAt(j)&&(temp+1)<haystack.length()) {
    //                 temp++;
    //                 j++;
    //                 flag++;
    //                 if (flag == needle.length())
    //                     return temp - needle.length();
    //             }
    //             break;
    //         }
    //     }
    //     return -1;
    // }
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (needle.length() > haystack.length()) return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // 如果当前字符与needle的第一个字符不匹配，继续
            // if (haystack.charAt(i) != needle.charAt(0))
            //     continue;

            // 检查剩余部分是否匹配
            boolean match = true;
            for (int j = 0; j < needle.length(); j++)
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            if (match) return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        l28 l28 = new l28();
        System.out.println(l28.strStr("a", "a"));
    }
}
