package re_08_2차원DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1520_2차원_DP_2트 {
    static int Y;
    static int X;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new int[Y][X];
        dp = new int[Y][X];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < X; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        move(0, 0);

        System.out.println(Arrays.stream(dp).flatMapToInt(Arrays::stream).max().getAsInt());
    }

    private static int move(int y, int x) {
        if (dp[y][x] != -1) {
            return dp[y][x];
        }
        if (y == Y - 1 && x == X - 1) {
            return 1;
        }
        int route = 0;
        for (int[] arr : wsaf) {
            int dy = y + arr[0];
            int dx = x + arr[1];

            if (0 <= dy && dy < Y && 0 <= dx && dx < X) {
                if (graph[y][x] > graph[dy][dx]) {
                    route += move(dy, dx);
                }
            }
        }
        dp[y][x] = route;
        return dp[y][x];
    }
}
