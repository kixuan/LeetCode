package 数组;

/**
 * @author kixuan
 * @version 1.0
 */
public class l146 {
    public int[] spiralArray(int[][] array) {
        // 添加特殊情况判断
        if (array == null || array.length == 0 || array[0].length == 0)
            return new int[0];

        int endy = array.length - 1, endx = array[0].length - 1;
        int startx = 0, starty = 0;
        int cnt = 0;
        int size = (endx + 1) * (endy + 1);
        int[] num = new int[size];

        // 首先注意跳出的时机，这里就不一定循环一整轮才跳出，必须每次遍历完就判断是否需要跳出
        while (true) {
            // 从左到右
            for (int i = startx; i <= endx; i++)
                num[cnt++] = array[starty][i];
            // 注意++starty和starty++的区别
            if(++starty > endy) break;

            // 从上到下
            for (int i = starty; i <= endy; i++)
                num[cnt++] = array[i][endx];
            if(--endx<startx)break;

            // 从右到左
            for (int i = endx; i >= startx; i--)
                num[cnt++] = array[endy][i];
            if(--endy<starty)break;

            // 从下到上
            for (int i = endy; i >= starty; i--)
                num[cnt++] = array[i][startx];
            if(++startx>endx)break;
        }
        return num;
    }


    public static void main(String[] args) {
        l146 l146 = new l146();
        int[][] array = {{2, 3}};
        int[] result = l146.spiralArray(array);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
