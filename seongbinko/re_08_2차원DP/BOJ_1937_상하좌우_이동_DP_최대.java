package re_08_2차원DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1937_상하좌우_이동_DP_최대 {
    static int N;
    static int[][] graph;
    static int[][] wsaf = new int[][]{
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{0, 1}
    };
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                move(y, x);
            }
        }
        // 2차원 배열에서 스트림을 사용하여 최댓값을 찾는 코드
        int max = Arrays.stream(dp)                // 2차원 배열을 스트림으로 변환
                .flatMapToInt(Arrays::stream)  // 각 행을 스트림으로 변환하고 단일 IntStream으로 병합
                .max()
                .getAsInt();// 최댓값 찾기

        // 최종 결과 출력
        System.out.println(max + 1); //판다 이동횟수를 계산했는데, 정답은 판다 이동 칸이라서 +1
    }

    // 2차원 dp는 경우의수가 상하좌우를 고려하면 됨
    private static int move(int y, int x) {
        if (dp[y][x] != 0) {
            return dp[y][x];
        }

        // 4방향 이동
        for (int[] arr : wsaf) {
            int dy = y + arr[0];
            int dx = x + arr[1];

            if (0 <= dy && 0 <= dx && dy < N && dx < N) {
                if (graph[y][x] < graph[dy][dx]) {
                    dp[y][x] = Math.max(dp[y][x], move(dy, dx) + 1);
                }
            }
        }
        return dp[y][x];
    }

}
