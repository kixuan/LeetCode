package 字符串;

/**
 * @author kixuan
 * @version 1.0
 */
public class l151 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                sb.append(words[i]).append(" ");
            }
        }
        // trim() 方法用于删除字符串的头尾空白符。
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        l151 l151 = new l151();
        System.out.println(l151.reverseWords("a good   example"));
    }
}
