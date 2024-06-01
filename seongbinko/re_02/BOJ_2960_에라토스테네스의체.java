package re_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2960_에라토스테네스의체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);

        // 2부터  ~ i*i <= n
        // 각각의 배수들을 지워간다.
        for (int i = 2; i < N + 1; i++) {
            if (isPrime[i]) {
                for (int j = i; j <= N; j += i) {
                    if (isPrime[j]) {
                        isPrime[j] = false;
                        S--;
                        if (S == 0) {
                            System.out.println(j);
                        }
                    }
                }
            }
        }
    }
}
