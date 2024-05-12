package week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1520_2차원_DP_끝까지가기 {

    static int Y, X;
    static int[][] directions = {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    static int[][] graph;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new int[Y][X];
        dp = new int[Y][X];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < X; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(recur(0, 0));
    }

    private static int recur(int y, int x) {
        if (y == Y - 1 && x == X - 1) {
            return 1;
        }
        if (dp[y][x] != -1) {
            return dp[y][x];
        }

        int route = 0;
        for (int i = 0; i < directions.length; i++) {
            int ey = y + directions[i][0];
            int ex = x + directions[i][1];

            if (ey >= 0 && ey < Y && ex >= 0 && ex < X) {
                // 이동 가능 조건
                if (graph[ey][ex] < graph[y][x]) {
                    route += recur(ey, ex);
                }
            }
        }
        dp[y][x] = route;
        return dp[y][x];
    }
}
