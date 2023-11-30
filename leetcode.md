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
class Hash.l350 {
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
class Hash.l350 {
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
class Hash.l350 {
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
class Hash.l350 {
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
class Hash.l350 {
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



## Hash

哈希表是**根据关键码的值而直接进行访问**的数据结构。

一般哈希表都是**用来快速判断一个元素是否出现集合里**。

哈希函数：一般hashcode是通过特定编码方式，可以将其他数据格式转化为不同的数值，这样就把数据映射为哈希表上的索引数字了。大于的话再进行取模

还极端的话就会出现哈希碰撞，解决办法：拉链法和线性探测法

拉链法：存在链表里面，注意要即不会因为数组空值而浪费内存，也不会因为链表过长再查找上浪费太多时间

<img src="https://code-thinking-1253855093.file.myqcloud.com/pics/20210104235015226.png" alt="哈希表4" style="zoom:50%;" />

线性探测法：往后再找空闲位置

<img src="https://code-thinking-1253855093.file.myqcloud.com/pics/20210104235109950.png" alt="哈希表5" style="zoom:50%;" />

常见的哈希结构：数组、set、map

map又分为HashMap、HashSet等

### 总结

总结一下，**当我们遇到了要快速判断一个元素是否出现集合里的时候，就要考虑哈希法**。

但是哈希法也是**牺牲了空间换取了时间**，因为我们要使用额外的数组，set或者是map来存放数据，才能实现快速的查找。

array适用于限制了数值大小的（而且不要太大，像26个字母【两个part为序号+值】

HashSet：如果哈希值比较少、**特别分散**、跨度非常大，**不考虑出现顺序**，使用数组就造成空间的极大浪费，这个时候就用HashSet，有了值再放进去【只有一个part是值】【但是set又要比数组空间和时间复杂度要高一点】

如果在做面试题目的时候遇到需要判断一个元素是否出现过的场景也应该第一时间想到哈希法！

#### 1. 快速查找

- **用途**：当你需要频繁检索特定元素是否存在于集合中时，哈希表是理想的数据结构。例如，在求解两个数组的交集或判断元素是否重复出现时。
- **实现**：使用 `HashSet` 存储元素，实现常数时间复杂度的查找操作。

#### 2. 计数和映射

- **用途**：当你需要对元素进行计数或建立元素与其相关数据的映射时。例如，在计算元素频率或分组数据时。
- **实现**：使用 `HashMap` 来映射元素到它们的计数或相关数据。

#### 3. 去重

- **用途**：在需要从数据中移除重复元素时。例如，在返回唯一元素集合的问题中。
- **实现**：使用 `HashSet` 存储已经遇到的元素，自动处理重复项。

#### 4. 子数组/子串问题

- **用途**：在处理子数组或子串的问题，如找出具有特定特性的最长子串。
- **实现**：使用 `HashMap` 记录字符及其在子串中的位置，帮助快速计算子串长度或验证其特性。

#### 5. 避免双重循环

- **用途**：在需要检查两个元素的组合是否满足特定条件时，如在数组中寻找和为特定值的一对数字。
- **实现**：使用 `HashMap` 或 `HashSet` 存储已经遍历过的元素，避免使用嵌套循环。

#### 6. 设计缓存机制

- **用途**：在需要设计缓存机制，如 LRU (Least Recently Used) 缓存时。
- **实现**：结合 `HashMap` 和双向链表实现高效的缓存机制。

#### 注意事项

- **哈希冲突**：了解哈希冲突及其解决方法（例如开放寻址法或链地址法）。
- **哈希函数的选择**：哈希函数应当能够均匀分布键以减少冲突。
- **空间复杂度**：虽然哈希表提供了优秀的时间性能，但可能会占用更多空间。



### 相关题目



**242.有效的字母异位词、383赎金信**

都是一种套路啦

1. 先一个for统计第一个的情况，再for和第二个的情况进行比较，第三个for查看是否合法

2. 也可以用HashMap两个for搞定，但是for里面还要if判断，时间反而更慢、、、

**349.两个数组的交集**

方法1：Hash + Array

空间效率高、可能更快，需要提前知道数据的范围来分配足够大小的数组。

1. 遍历两个数组，获取hash序号
2. 找到两个数组交集的序号
3. 根据交集序号把数组值放进新的数组里

方法2：HashSet

适合处理大数据范围，但是空间复杂度会高

1. 遍历一个数组，获取hash序号
2. 遍历第二个数组，获取交集序号（set.contain(num[i])）
3. 根据交集序号把数组值放进新的数组里



**350.两个数组的交集Ⅱ**

这个要显示重复的，不能用hashset，所以用hash + array

只要把第二步找交集序号的if改成while就行



**202.快乐数（我靠我一点都不快乐）**

首先写个函数找下一个数的平方

我们猜测会有以下三种可能。

1. 最终会得到 1。
2. 最终会进入循环。
3. 值会越来越大，最后接近无穷大。

首先排除3，因为不会越来越大

| Digits |    Largest    | Next |
| ------ | :-----------: | ---: |
| 1      |       9       |   81 |
| 2      |      99       |  162 |
| 3      |      999      |  243 |
| 4      |     9999      |  324 |
| 13     | 9999999999999 | 1053 |

再分析2：如果hashset没有包含过则添加进去，包含的话就说明会循环，不是快乐数

![image-20231125190930911](https://cdn.jsdelivr.net/gh/kixuan/PicGo/images/image-20231125190930911.png)



1.两数之和【知一找一】

首先的想法是两层for暴力，时间复杂度太高了

用HashMap就只用循环一遍，慢慢把整个数组变成HashMap，可以快速查找【map.containKey(key)/map.put(key,value)/map.get(key)】

**选择HashMap还是HashSet：是否需要键值对来存储数据（使用 `HashMap`），还是仅需要存储不重复的值（使用 `HashSet`）**



**15.三数之和**

排序+双指针

**首先一定要排序，排序后求和找值都会方便很多**

排序之后就一个个遍历，再用双指针找后面两个的位置

相当于排序确定第一个位置，双指针确定后面两个的位置，加起来就是三个数了（之前的排序这里就方便直接移动左指针或者右指针）

剩下还有一些细节比如处理一些特判，**处理重复解**（这里也巧用排序，如果相邻的数相同的话我们就直接skip，避免重复）

复杂度的话就是O(n^3)降为O(n^2)



**18.四数之和（啊？？？？）**

也是排序+双指针（找最后两个数），但是要多一层for找第二个数

好多特殊情况可以处理：

1. 首先第一次循环第一个数从头遍历，跳过重复的数避免重复的组合，如果现在的最小的四个数都＞target，直接break
2. 那如果第一个数加最大的三个数都＜target，这轮直接continue
3. 第二轮遍历第二个数，同1、2的逻辑提前终止循环
4. 再用双指针遍历剩余的两个数



**454.四数之和Ⅱ**

这个就简单多了（但也考思路

因为只用统计数量而不用返回数组，所以我们根本不考虑数组下标，直接ab分为1组算总和放进hashmap（因为要算次数还是要考虑重复值，所以不用hashset），cd分一组算有没有-（a+b），有的话计算器加1就行
