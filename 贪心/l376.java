package 贪心;

class l376 {
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if(length<=1) return length;
        // 起始位置也算在里面
        int cnt = 1 ;

        // v1.0
        // for(int i =1 ;i < length-2; i++){
        //     if((nums[i]>nums[i+1])&&(nums[i+1]<nums[i+2])||
        //     (nums[i]<nums[i+1]&&(nums[i+1]>nums[i+2]))){
        //         cnt+=2;
        //     }
        // }

        //v2.0 峰值什么时候出现
        int prediff = 0;
        int nextdiff = 0;
        for(int i = 0 ;i < length-1; i++){
            nextdiff = nums[i+1] - nums[i];
            // = 考虑平坡位置
            if((prediff >=0 && nextdiff<0) || (prediff <=0 && nextdiff>0)){
                cnt++;
                prediff = nextdiff;
            }
        }
        return cnt;
    }
}