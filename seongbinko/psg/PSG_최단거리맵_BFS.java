package psg;

import java.util.Deque;
import java.util.LinkedList;

public class PSG_최단거리맵_BFS {
    public static void main(String[] args) {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        PSG_최단거리맵_BFS object = new PSG_최단거리맵_BFS();
        System.out.println(object.solution(maps));
    }
    // 1: 이동가능 0:벽
    // 도달 할 수 없을 때는 -1 return

    static int[][] visited;
    static int[][] dist;
    static int[][] wsadList = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public int solution(int[][] graph) {
        int Y = graph.length;
        int X = graph[0].length;
        int answer = -1;

        visited = new int[Y][X];
        dist = new int[Y][X];
        visited[0][0] = 1;
        dist[0][0] = 1;
        Deque<int[]> q = new LinkedList<>();
        q.offerLast(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] dydx = q.pollFirst();
            // '1'인 곳만 이동이 가능
            // 상하좌우 탐색, 범위를 벗어나서는 이동할 수 없음
            for (int[] wasd : wsadList) {
                int ny = dydx[0] + wasd[0]; // 이동할 y 좌표
                int nx = dydx[1] + wasd[1]; // 이동할 x 좌표

                if (0 <= ny && ny < Y && 0 <= nx && nx < X) {
                    if (visited[ny][nx] == 1) {
                        continue;
                    }
                    if (graph[ny][nx] == 1) {
                        visited[ny][nx] = 1;
                        dist[ny][nx] = dist[dydx[0]][dydx[1]] + 1;

                        // 도달하지 못한다면 -1을 return 해야함
                        if (ny == Y - 1 && nx == X - 1) {
                            answer = Math.max(answer, dist[ny][nx]);
                        }
                        q.offerLast(new int[]{ny, nx});
                    }
                }
            }
        }
        return answer;
    }
}
