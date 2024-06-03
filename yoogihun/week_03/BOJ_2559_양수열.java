package week_03;

import java.util.Scanner;

public class BOJ_2559_양수열 {
    public static void main(String[] args) {
        /**
         * 수열의 길이 A와, 간격 B가 주어집니다.
         * 그리고 수열이 하나 주어집니다.
         * 주어진 간격만큼의 합을 구해서, 가장 큰 수를 출력하는 프로그램을 작성하세요.
         * 10 2
         * 3 -2 -4 -9 0 3 7 13 8 -3
         * 21
         */
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[] array = new int[a];

        for (int i = 0; i < a; i++) {
            array[i] = scanner.nextInt();
        }

        //prefix의 다음값은 array의 값과 프리픽스를 더한값이다.
        int[] prefix = new int[a + 2];
        for (int i = 0; i < a; i++) {
            prefix[i + 1] = prefix[i] + array[i];
        }

        // 최대값 계산
        //프리픽스는 2부터 시작하고, 인덱스 2번째 뒤에있는걸 빼면 합한 값과 같음
        int max = Integer.MIN_VALUE;
        for (int k = b; k <= a; k++) {
            max = Math.max(max, prefix[k] - prefix[k - b]);
        }

        // 결과 출력
        System.out.println(max);
    }
}
