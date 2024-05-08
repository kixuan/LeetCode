import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Discount {
        int a; // 满减条件
        int b; // 减少金额
        double ratio; // 性价比

        public Discount(int a, int b) {
            this.a = a;
            this.b = b;
            this.ratio = b * 1.0 / a;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 样例组数
        while (T-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            List<Discount> discounts = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                discounts.add(new Discount(a, b));
            }
            System.out.println(maxPurchasePrice(discounts, m));
        }
        scanner.close();
    }

    private static int maxPurchasePrice(List<Discount> discounts, int m) {
        // 按性价比从高到低排序
        discounts.sort((d1, d2) -> Double.compare(d2.ratio, d1.ratio));
        long maxPrice = m; // 初始化最大原价为用户的初始金额

        for (Discount discount : discounts) {
            if (maxPrice >= discount.a) {
                maxPrice += discount.b; // 如果当前余额满足优惠条件，应用优惠
            }
        }

        return (int) maxPrice;
    }
}