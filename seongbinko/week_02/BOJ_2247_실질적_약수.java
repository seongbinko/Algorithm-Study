package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2247_실질적_약수 {
    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i == j) {
                    continue;
                }
                if (i % j == 0) {
                    sum += j;
                    if (j != i / j) {
                        sum += i / j;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    /**
     * https://dksek3050.tistory.com/m/68
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        for (int i = 2; i < n; i++) {
            sum += ((n/i)-1) * i;
        }

        System.out.println(sum%1000000);
    }
}
