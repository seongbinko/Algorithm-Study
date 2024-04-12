package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11653_소인수_분해 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1번
        int j = 2;
        for (int i = 2; i < N + 1; i = j) {
            if (N % i == 0) {
                System.out.println(i);
                N = N / i;
                j = 2;
                continue;
            }
            j++;
        }
        // 2번
        for (int i = 2; i < N + 1; i++) {
            while (N % i == 0) {
                System.out.println(i);
                N = N / i;
            }
        }
    }
}
