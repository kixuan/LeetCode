## 数组

**数组是存放在连续内存空间上的相同类型数据的集合，下标都是从0开始。**

连续 ==> 查找方便，新增/删除不方便【数组的元素是不能删的，只能覆盖】

### 1、二分查找

**题目：**[704. 二分查找 - 力扣（LeetCode）](https://leetcode.cn/problems/binary-search/description/)

前提：**数组为有序数组 + 数组中无重复元素**

**难点：**对区间的定义想清楚  ==》 保持不变量（在while寻找中每一次边界的处理都要坚持根据区间的定义来操作） ==》**循环不变量**规则

1. 左闭右闭   [left, right]

   - 范围包含right

   - left = right 时是有意义的，也就是在中间只有一个数的时候 ==》 while (left <= right)  

   - 左右边界变的时候要多移一位

2. 左开右闭   [left, right)  ==> while (left < right)

   - 范围不包含right
   - left = right 时是没有意义的 ==》 while (left < right)  
   - left需要多移动一位，right不需要，因为反正也不包含

   [1，2，3]和[1，2，3）的区别

**示例：**Java左闭右闭区间

```java
class Solution {
    public int search(int[] nums, int target) {
    // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1])      return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }
}
```

- 时间复杂度：O(log n)
- 空间复杂度：O(1)



### 2、移除元素【快慢指针】

**题目：**[27. 移除元素 - 力扣（LeetCode）](https://leetcode.cn/problems/remove-element/description/)

**前提：**数组中在保持基本顺序不变的前提下，删除指定元素（主要是减少空间复杂度）

**难点：**理解快慢指针的具体含义

- 快指针：寻找新数组的元素 ，新数组就是不含有目标元素的数组
- 慢指针：指向更新 新数组下标的位置

![27.移除元素-双指针法](https://code-thinking.cdn.bcebos.com/gifs/27.%E7%A7%BB%E9%99%A4%E5%85%83%E7%B4%A0-%E5%8F%8C%E6%8C%87%E9%92%88%E6%B3%95.gif)

**示例：**

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        // 快慢指针
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}
```

- 时间复杂度：O(n)
- 空间复杂度：O(1)

相关题目：

- [26. 删除有序数组中的重复项 - 力扣（LeetCode）](https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/)：额感觉没有用到快慢指针，如果前一项不等于这一项，那就要把这一项放进数组【有点绕】

- [283. 移动零 - 力扣（LeetCode）](https://leetcode.cn/problems/move-zeroes/description/)：先用快慢指针筛选出不含0的子数组，再在数组后面全部置0

- [844. 比较含退格的字符串 - 力扣（LeetCode）](https://leetcode.cn/problems/backspace-string-compare/description/)：巧用StringBuilder，用append实现添加操作，deleteCharAt方法实现退格操作

  

  

### 3、有序数组的平方【快慢指针】

题目： [977. 有序数组的平方 - 力扣（LeetCode）](https://leetcode.cn/problems/squares-of-a-sorted-array/description/)

前提： **非递减顺序** 排序

难点：非递减 ==》 平方大小两边向中间递减 ==》 对向双指针移动的逻辑

实现：

```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int p=nums.length-1;
        int[] arr=new int[nums.length];
        int left=0;
        int right=nums.length-1;
        while(left <= right){
            // 对向移动
           if(Math.abs(nums[left]) > Math.abs(nums[right])){
                arr[p]=nums[left] * nums[left];
                left++;
            }else{
                arr[p]=nums[right] * nums[right];
                right--;
            }
            p--;
        }
        return arr;
    }
}
```

- 时间复杂度：O(n)
- 空间复杂度：O(1)



### 4、长度最小的子数组【滑动窗口】

题目：[209. 长度最小的子数组 - 力扣（LeetCode）](https://leetcode.cn/problems/minimum-size-subarray-sum/description/)

前提：问题涉及连续子数组或子字符串

难点：不断的调节子序列的起始位置和终止位置，注意for表示的是窗口的终止位置，每次for先确定终止位置再不断向前调整起始位置

![209.长度最小的子数组](https://code-thinking.cdn.bcebos.com/gifs/209.%E9%95%BF%E5%BA%A6%E6%9C%80%E5%B0%8F%E7%9A%84%E5%AD%90%E6%95%B0%E7%BB%84.gif)

示例：

滑动窗口的精妙之处在于根据当前子序列和大小的情况，不断调节子序列的起始位置。从而将O(n^2)暴力解法降为O(n)。

![leetcode_209](https://code-thinking-1253855093.file.myqcloud.com/pics/20210312160441942.png)



```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = nums.length + 1;
        int sum = 0;
        int left = 0;

        // 滑动窗口，移动的是终止位置
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= target) {
                result = Math.min(result, i - left + 1);
                // 每次直接从确定的初始位置开始移动，因为是已经计算过的长度最短
                sum -= nums[left];
                left++;
            }
        }
        return result == nums.length + 1 ? 0 : result;
    }
}
```

相关题目推荐：【还没做捏】

- [904. 水果成篮 - 力扣（LeetCode）](https://leetcode.cn/problems/fruit-into-baskets/description/)
- [76. 最小覆盖子串 - 力扣（LeetCode）](https://leetcode.cn/problems/minimum-window-substring/description/)



### 5、螺旋矩阵Ⅱ【模拟】

题目：[59. 螺旋矩阵 II - 力扣（LeetCode）](https://leetcode.cn/problems/spiral-matrix-ii/description/)

前提：好像没什么前提🤔

难点：模拟过程，边界处理，坚持循环不变量原则

示例：

```java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        // 主要是定义的这四个变量对边界的处理
        int startx=0,starty=0;
        int endx=n-1,endy=n-1;
        int cnt=1;

        while(cnt<=n*n){
            // 从左到右
            for(int i=startx;i<=endx;i++){
                arr[starty][i]=cnt++;
            }
            starty++;

            // 从上到下
            for(int i = starty;i<=endy;i++)
                arr[i][endx]=cnt++;
            endx--;

            // 从右到左
            for(int i = endx;i>=startx;i--)
                arr[endy][i]=cnt++;
            endy--;

            // 从下到上
            for(int i =endy;i>=starty;i--)
                arr[i][startx]=cnt++;
            startx++;
        }
        return arr;
    }
}

```



相关题目推荐：【还没做完捏】

- [54. 螺旋矩阵 - 力扣（LeetCode）](https://leetcode.cn/problems/spiral-matrix/description/)
- [LCR 146. 螺旋遍历二维数组 - 力扣（LeetCode）](https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/description/)：思路很像，但注意跳出的时机，这里就不一定循环一整轮才跳出，必须每次遍历完就判断是否需要跳出，而且注意区别++i和i++的区别

### 总结

![img](https://code-thinking-1253855093.file.myqcloud.com/pics/%E6%95%B0%E7%BB%84%E6%80%BB%E7%BB%93.png)



## 链表





438.找到字符串中所有字母...

滑动窗口方法：

先统计父字符串和目标的hash字母数组频率

然后对这个父字符串数组 进行滑动窗口，和目标数组比较

记得用arrays的equals比较方便
