package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kixuan
 * @version 1.0
 */
public class l383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> hm = new HashMap<>();
        for(Character c : magazine.toCharArray()){
            if(hm.get(c)==null)
                hm.put(c,1);
            else if (hm.get(c)>0)
                hm.put(c,hm.get(c)+1);
        }
        for(Character c : ransomNote.toCharArray()){
            if(hm.get(c)==null)
                return false;
            else if (hm.get(c)>0){
                hm.put(c,hm.get(c)-1);
                if (hm.get(c)<0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        l383 l383 = new l383();
        System.out.println(l383.canConstruct("aa", "ab"));
    }
}
