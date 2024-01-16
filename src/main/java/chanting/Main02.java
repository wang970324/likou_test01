package chanting;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] cells = new int[n];
        for (int i = 0; i < n; i++) {
            cells[i] = scanner.nextInt();
        }

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = cells[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], cells[i]);
        }

        rightMax[n - 1] = cells[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], cells[i]);
        }

        int drops = 0;
        for (int i = 0; i < n; i++) {
            int maxHeight = Math.min(leftMax[i], rightMax[i]);
            if (maxHeight > cells[i]) {
                drops += maxHeight - cells[i];
            }
        }

        System.out.println(drops);
    }

}
