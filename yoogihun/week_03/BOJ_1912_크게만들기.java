package week_03;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1912_크게만들기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int a = scanner.nextInt();
        int[] array = new int[a];

        for (int i = 0; i < a; i++) {
            array[i] = scanner.nextInt();
        }
        //합계를 넣기 때문에 a+1개만큼 배열이 생성되어야함
        int[] prefix = new int[a+1];

        //연속된 수를 더한 값과 다음 배열의 값 중 더 큰걸로 넣어줌
        for (int i = 0; i < a; i++) {
            prefix[i+1] = Math.max(prefix[i] + array[i], array[i]);
        }

        Arrays.stream(prefix).forEach(num -> System.out.println(num));
    }
}
