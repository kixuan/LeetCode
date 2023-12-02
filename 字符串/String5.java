package 字符串;

/**
 * @author kixuan
 * @version 1.0
 */
public class String5 {
    public String RightReverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        String endStr = sb.substring(sb.length()-k);
        sb.delete(sb.length()-k,sb.length());
        sb.insert(0,endStr);
        return sb.toString();
    }

    public static void main(String[] args) {
        String5 string5 = new String5();
        System.out.println(string5.RightReverseStr("abcdefg", 2));
    }


}
