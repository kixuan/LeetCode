package Hash;

import java.util.ArrayList;
import java.util.List;

class l350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] hash1 = new int[1002];
        int[] hash2 = new int[1002];
        for(int i : nums1)
            hash1[i]++;
        for(int i : nums2)
            hash2[i]++;
        List<Integer> resList = new ArrayList<>();
        for(int i = 0; i < 1002; i++)
            if(hash1[i] > 0 && hash2[i] > 0)
                resList.add(i);
        int index = 0;
        int res[] = new int[resList.size()];
        for(int i : resList)
            res[index++] = i;
        return res;
    }
    public static void main(String[] args) {
        l350 l350 = new l350();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] res = l350.intersect(nums1, nums2);
        for(int i : res)
            System.out.println(i);
    }
}