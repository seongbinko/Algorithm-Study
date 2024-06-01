package re_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978_소수찾기_2트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input == 1) {
                continue;
            }
            boolean isPrime = true;
            for (int j = 2; j < input; j++) {
                if (input % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
