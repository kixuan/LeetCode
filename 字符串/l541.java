package 字符串;

/**
 * @author kixuan
 * @version 1.0
 */
public class l541 {
    public String reverseStr(String s, int k) {
        int size = s.length();
        for (int i = 0; i < size; i += 2 * k) {
            // 剩余字符大于等于 k 个，则反转前 k 个字符。
            if (i + k < size) {
                s = reverse(s, i, i + k - 1);
            }
            // 剩余字符少于 k 个，则将剩余字符全部反转。
            else {
                s = reverse(s, i, size - 1);
            }
        }

        return s;
    }

    private String reverse(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        for (; i < j; i++, j--) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
        }
        s = sb.toString();
        return s;
    }

    public static void main(String[] args) {
        l541 l541 = new l541();
        System.out.println(l541.reverseStr("abcdefg", 2));
    }
}

