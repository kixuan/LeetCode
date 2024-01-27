package 贪心;

import java.util.Arrays;

class l455 {
    public int findContentChildren(int[] g, int[] s) {
        // 加上特判
        int index = s.length - 1;
        if (index == -1) return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int cnt = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] >= g[index]) {
                index--;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {3};
        l455 l = new l455();
        System.out.println(l.findContentChildren(g, s));
    }
}

