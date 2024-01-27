package 贪心;

class l45 {
    public int jump(int[] nums) {
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            cnt++;
            for (int j = 1; j <= nums[i]; j++) {
                if (((j < nums.length) && (nums[i] + nums[j]) > max)) {
                    max = nums[i] + nums[j];
                }
                cnt++;
                if (max >= nums.length)
                    return cnt;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        l45 l = new l45();
        System.out.println(l.jump(nums));
    }
}