package 双指针;

/**
 * @author kixuan
 */
public class l11 {
    // 难点在于想要从两边向中间移动
    public int maxArea(int[] height) {
        // maxArea = 长 * 宽
        // 不要想着从头到尾，而应该是两头向中间，这样适合算面积的
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                maxArea = Math.max(maxArea, (j - i) * height[i++]);
            } else {
                maxArea = Math.max(maxArea, (j - i) * height[j--]);
            }
        }
        // 优雅三元表达式
        // maxArea = height[i] < height[j] ? Math.max(maxArea, (j - i) * height[i++]) : Math.max(maxArea, (j - i) * height[j--]);
        return maxArea;
    }
}
