class Solution3 {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i])
                return i;
            leftSum += nums[i];
        }
        return -1;
    }
}

//时间 1ms 击败 36.22%使用 Java 的用户
//内存 38.48mb  击败 93.64%使用 Java 的用户