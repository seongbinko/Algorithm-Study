package week_02;

import java.util.Scanner;


public class BOJ_1978_소수구하기 {
    public static void main(String[] args) {
        /**
         * 주어진 수 N개 중에서 소수는 몇 개 인가?
         * 소수: 1과 자기 자신으로만 나누어 떨어지는 수
         * 2,3,5,7,11,13...
         * 2보다 작으면 안된다.
         * 소수는 제곱근보다 큰 수로 안나누어짐
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("주어진 수의 개수를 입력: ");
        int n = scanner.nextInt();
        int[] list = new int[n];

        System.out.println(n + "개의 수를 입력하세요:");
        for (int i = 0; i < n; i++) {
            list[i] = scanner.nextInt();
        }

        int cnt = 0;
        for (int i = 0; i < list.length; i++) {
            if (checked(list[i])) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static boolean checked(int num) {
        if (num < 2) {
            return false;
        }
        int standard = (int) Math.sqrt(num);
        for (int i = 2; i <= standard; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
