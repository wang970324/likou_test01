package chanting;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        scanner.nextLine(); // 读取换行符

        for (int i = 0; i < k; i++) {
            long m = scanner.nextLong();
            int n = calculateN(m);
            System.out.println(n);
        }

        scanner.close();
    }

    private static int calculateN(long m) {
        int n = 0;
        while ((1L << n) < m) {
            n++;
        }
        return n;
    }
}
