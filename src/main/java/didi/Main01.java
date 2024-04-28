package didi;

import java.util.Arrays;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 书的数量
        int m = scanner.nextInt(); // 优惠券数量

        int[] bookPrices = new int[n];
        for (int i = 0; i < n; i++) {
            bookPrices[i] = scanner.nextInt();
        }

        Arrays.sort(bookPrices); // 将书的价格从低到高排序

        int[] coupons = new int[m];
        for (int i = 0; i < m; i++) {
            coupons[i] = scanner.nextInt();
        }

        Arrays.sort(coupons); // 将优惠券的要求从低到高排序

        long total = 0; // 总价
        int j = n - 1; // 从最贵的书开始
        for (int i = m - 1; i >= 0; i--) { // 从最多书的优惠券开始使用
            if (coupons[i] == 1) {
                total += bookPrices[j]; // 无需优惠券，直接买最贵的书
                j--;
            } else {
                total += bookPrices[j]; // 先买最贵的一本书
                j -= (coupons[i] - 1); // 再买优惠券要求的数量减一的书
            }
        }

        while (j >= 0) { // 如果优惠券用完了还有书未买
            total += bookPrices[j];
            j--;
        }

        System.out.println(total);
    }
}
