package week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1937_2차원_DP {

    static int n;
    static int[][] graph;
    static int[][] directions = {
            {-1, 0}, // 위 (상)
            {1, 0},  // 아래 (하)
            {0, -1}, // 왼쪽 (좌)
            {0, 1}   // 오른쪽 (우)
    };
    static int[][] dp;

    // 1. 옮기는 지역의 대나무양이 더 많아야한다.
    // 2. 상하좌우                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           ]
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
/**
 * 경우의 수(재귀) !!시간초과!! -> DP 필요 -> 점화식 (필요하지 않을 수도 있음)
 for (int i = 0; i < graph.length; i++) {
 for (int j = 0; j < graph[i].length; j++) {
 int result = recur(i, j);
 System.out.println(String.format("%d %d %d", i, j, result));
 answer = Math.max(answer, result);
 }
 }
 */
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                int result = recur(i, j);
//                System.out.println(String.format("%d %d %d", i, j, result));
            }
        }
        int max = Arrays.stream(dp)
                .flatMapToInt(Arrays::stream) // 2차원 배열을 평면화하여 int 스트림 생성
                .max().getAsInt();

        System.out.println(max + 1);
    }

    // 판다가 이동한 횟수를 구한것
    // 판다가 이동한 칸의 수라면 마지막값에 1을 더해야함
    private static int recur(int y, int x) {

        if (dp[y][x] != 0) {
            return dp[y][x];
        }

        for (int i = 0; i < directions.length; i++) {
            int dy = y + directions[i][0];
            int dx = x + directions[i][1];
            if (dy >= 0 && dy < n && dx >= 0 && dx < n) {
                if (graph[dy][dx] > graph[y][x]) {
                    dp[y][x] = Math.max(dp[y][x], recur(dy, dx) + 1);
                }
            }
        }
        return dp[y][x];
    }
}
