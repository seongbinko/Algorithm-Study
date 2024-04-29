package week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11660_구간_합_구하기_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 4
        int m = Integer.parseInt(st.nextToken()); // 3

        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] prefix = new int[n + 1][n + 1];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                prefix[y + 1][x + 1] = prefix[y + 1][x] + prefix[y][x + 1] + graph[y][x] - prefix[y][x];
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            // (2,2) (4,3)
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            // 42 - 6 - 10 + 1
            int result = prefix[y2][x2] - prefix[y1-1][x2] - prefix[y2][x1-1] + prefix[y1-1][x1-1];
            answer.add(result);
        }
        for (Integer i : answer) {
            System.out.println(i);
        }
    }
}
