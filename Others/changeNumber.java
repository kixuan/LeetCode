package Others;

/**
 * @author kixuan
 * @version 1.0
 */
public class changeNumber {
    public String toNumber(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) >= '1' && sb.charAt(i) <= '9') {
                sb.deleteCharAt(i);
                sb.insert(i, "number");
            }
        }
        s = sb.toString();
        return s;
    }
}
