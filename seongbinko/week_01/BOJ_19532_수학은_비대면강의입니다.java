package week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 연립방정식 문제
 */
public class BOJ_19532_수학은_비대면강의입니다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(String.valueOf(br.readLine()).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        int d = arr[3];
        int e = arr[4];
        int f = arr[5];

        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if (a * x + b * y == c && d * x + e * y == f) {
                    System.out.println(String.format("%s %s", x, y));
                }
            }
        }

    }
}
