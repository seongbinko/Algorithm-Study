package re_12_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 최단 거리를 구해야 할 때 DFS는 어디로 튈지 예측을 할 수 없다.
 * 가장 먼 곳까지 이동 (완전탐색 사고) + 최단거리 (BFS)
 * 그래서 그래프 탐색에는 BFS가 유리하다.
 */
public class BOJ_2589_BFS_보물섬_2트 {
    static int Y;
    static int X;
    static String[][] graph;
    static int maxi = Integer.MIN_VALUE;
    static int[][] wsadList = new int[][]{
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{0, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new String[Y][X];

        // 초기화

        for (int i = 0; i < Y; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < X; j++) {
                graph[i][j] = split[j];
            }
        }

        // bfs
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                // 시작 가능 조건
                if (graph[y][x].equals("L")) {
                    int[][] visited = new int[Y][X];
                    int[][] dist = new int[Y][X];

                    Deque<int[]> q = new LinkedList<>();
                    q.offerLast(new int[]{y, x});
                    visited[y][x] = 1;

                    while (!q.isEmpty()) {
                        // 해당 좌표에서 nynx까지의 거리를 dist에 기록한다.
                        int[] dydx = q.pollFirst();
                        for (int[] wasd : wsadList) {
                            // nxt
                            int ny = dydx[0] + wasd[0];
                            int nx = dydx[1] + wasd[1];
                            //내가 가야할 곳이  그래프 안에 있는지 확인
                            if (0 <= ny && ny <= Y - 1 && 0 <= nx && nx <= X - 1) {
                                if (graph[ny][nx].equals("W")) {
                                    continue;
                                }
                                if (visited[ny][nx] == 1) {
                                    continue;
                                }
                                // L 이면
                                // 갈 곳 방문처리
                                visited[ny][nx] = 1;
                                // 거리 계산 내가 갈거리는 내가 출발한 거리 +1
                                dist[ny][nx] = dist[dydx[0]][dydx[1]] + 1;
                                maxi = Math.max(maxi, dist[ny][nx]); // 내가 출발 한 곳에서 갈 수 있는 가장 먼 곳을 업데이트, 최단거리를 구하라는 것은 BFS로 판단 가능
                                q.offerLast(new int[]{ny, nx});
                            }
                        }
                    }
                }
            }
        }
        System.out.println(maxi);
    }
}
