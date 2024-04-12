package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978_소수_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(st.nextToken());
            if (M <= 1) {
                continue;
            }
            boolean result = true;
            for (int j = 2; j <= Math.sqrt(M); j++) {
                if (M % j == 0) {
                    result = false;
                    break;
                }
            }
            if (result) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
