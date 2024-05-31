package re_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14568_2트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                for (int c = 1; c < 100; c++) {
                    if (a + b + c == N) {
                        if (c >= b + 2) {
                            if (a % 2 == 0) {
                                System.out.println(String.format("%d %d %d", a, b, c));
                                answer++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);

    }

}
