package re_08_2차원DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];


        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int y = 1; y < N; y++) {
            for (int x = 1; x < N; x++) {
                int count = move(y, x);
//                System.out.println(y + " " + x + " " + count);
                answer = Math.max(answer, count);
            }
        }
        System.out.println(answer + 1);
    }

    private static int move(int y, int x) {
        int point = 0; // 4방향 중 가장 큰 값을 return 해야한다.
        // 4방향 이동
        for (int[] arr : wsaf) {
            int dy = y + arr[0];
            int dx = x + arr[1];

            if (0 < dy && 0 < dx && dy < N && dx < N) {
                if (graph[y][x] < graph[dy][dx]) {
                    point = Math.max(point, move(dy, dx) + 1);
                }
            }
        }
        return point;
    }

}
