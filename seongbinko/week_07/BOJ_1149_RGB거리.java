package week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][3];
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken()); // r
            graph[i][1] = Integer.parseInt(st.nextToken()); // g
            graph[i][2] = Integer.parseInt(st.nextToken()); // b
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (i >= 1) {
                    // R(0) G(1) B(2) 에서 0이면, 나를 뺀 나머지의 dp 값 중 최소값 + 나의 값이 현재 최소값이 될 것 이다.
                    dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + graph[i][j];
                } else {
                    dp[i][j] = graph[i][j];
                }
            }
        }
        System.out.println(Arrays.stream(dp[n - 1]).min().getAsInt());
    }
}
