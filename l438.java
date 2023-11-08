import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kixuan
 * @version 1.0
 */
public class l438 {
    // public List<Integer> findAnagrams(String s, String p) {
    //     List<Integer> num = new ArrayList<Integer>();
    //     for (int i = 0; i < s.length(); i++) {
    //         int[] has = new int[26];
    //         boolean flag = true;
    //         for (int j = 0; j < p.length(); j++)
    //             has[s.charAt(i+j) - 97]++;
    //
    //         for (int a = 0; a < p.length(); a++)
    //             has[p.charAt(a) - 97]--;
    //
    //         for (int b = 0; b < 26; b++) {
    //             if (has[b] != 0) {
    //                 flag = false;
    //                 break;
    //             }
    //         }
    //         if (flag) num.add(i);
    //     }
    //     return num;

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> num = new ArrayList<Integer>();
        int[] s_num = new int[26];
        int[] p_num = new int[26];


        for (int i = 0; i < p.length(); i++) {
            s_num[s.charAt(i) - 97]++;
            p_num[p.charAt(i) - 97]++;
        }
        // 判断首位
        if (Arrays.equals(s_num, p_num))
            num.add(0);

        for (int i = 0; i < s.length() - p.length(); i++) {
            s_num[s.charAt(i) - 97]--;
            s_num[s.charAt(i + p.length()) - 97]++;

            if (Arrays.equals(s_num, p_num))
                num.add(i+1);
        }
        return num;
    }


    public static void main(String[] args) {
        l438 l438 = new l438();
        System.out.println(l438.findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));
    }
}
