/**
 * @author kixuan
 * @version 1.0
 */
public class l242 {
    public boolean isAnagram(String s, String t) {
        int[] has = new int[26];
        for(int i=0;i<s.length();i++)
            has[s.charAt(i)-97]++;

        for(int i=0;i<t.length();i++)
            has[t.charAt(i)-97]++;

        for(int i=0;i<26;i++)
            if(has[i]!=0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        l242 l242 = new l242();
        System.out.println(l242.isAnagram("anagram", "nagaram"));
    }
}
