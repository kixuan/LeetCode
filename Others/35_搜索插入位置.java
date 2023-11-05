//直接暴力
class Solution1 {
    public int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(target <= nums[i])
                return i;
        }
        return nums.length;
    }
}
//时间-ms 击败 100.00%使用 Java 的用户
//内存 41.26mb 击败 30.32%使用 Java 的用户


//二分法
class Solution2 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            // 防止 left+right 整型溢出
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        return left;
    }
}
