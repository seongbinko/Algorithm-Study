package week_02;

import java.util.Scanner;

public class BOJ_15736_청기백기 {
    public static void main(String[] args) {
        /**
         * N=3, o=청색, x=백색
         * 3개의 깃발이 존재함
         * 1 2 3 4 5
         * x x x x x
         *   o   o
         *     o
         *       x
         *         o
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cnt = 0;
        for (int i = 1; i * i <= n; i++) {
            cnt++;
        }
        System.out.println(cnt);
    }
}
