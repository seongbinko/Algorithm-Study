package week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2589_BFS_보물섬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] graph = new char[n][m];
        for (int i = 0; i < n; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        int maxi = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (graph[y][x] == 'L') {
                    // Initialize visited and distance arrays
                    boolean[][] visited = new boolean[n][m];
                    int[][] dist = new int[n][m];

                    // BFS
                    Deque<int[]> q = new LinkedList<>();
                    q.add(new int[]{y, x});
                    visited[y][x] = true;

                    while (!q.isEmpty()) {
                        int[] point = q.pollFirst();
                        int ey = point[0];
                        int ex = point[1];

                        // 4-directional search
                        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                        for (int[] dir : directions) {
                            int ny = ey + dir[0];
                            int nx = ex + dir[1];
                            // 내가 갈 곳이 L이며, 방문하지 않았어야한다.
                            if (ny >= 0 && ny < n && nx >= 0 && nx < m && graph[ny][nx] == 'L' && !visited[ny][nx]) {
                                visited[ny][nx] = true;
                                dist[ny][nx] = dist[ey][ex] + 1;
                                if (maxi < dist[ny][nx]) {
                                    maxi = dist[ny][nx];
                                }
                                q.add(new int[]{ny, nx});
                            }
                        }
                    }
                }
            }
        }

        System.out.println(maxi);
    }
}

