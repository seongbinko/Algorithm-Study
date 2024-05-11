package week_02;

import java.util.Scanner;

public class BOJ_1407_숨어있는숫자찾기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("두 개의 정수를 입력하세요:");
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int sum = 0;
        for (int num = A; num <= B; num++) {
            int cnt = 0;
            // 숫자 num의 약수 중 2의 제곱수를 찾아 개수를 증가시킴
            for (int i = 0; Math.pow(2, i) <= num; i++) {
                if (num % Math.pow(2, i) == 0) {
                    cnt++;
                }
            }
            sum += cnt;
        }

        System.out.println("숫자 범위 내의 2의 제곱수 약수의 개수의 합: " + sum);

        scanner.close();
    }
}


