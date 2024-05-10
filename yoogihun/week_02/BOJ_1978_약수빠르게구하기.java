package week_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_1978_약수빠르게구하기 {
    public static void main(String[] args) {
        /**
         * 15의 약수
         * 1,3,5,15
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int standard = (int) Math.sqrt(n);

        for (int i = 1; i <= standard; i++) {
            if (n % i == 0) {
                System.out.print(i+" ");
                System.out.println(n/i);
            }
        }
    }
}
