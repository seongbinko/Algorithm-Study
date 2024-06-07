package re_12_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BFS가 그래프 탐색에 좋다!
 * <p>
 * DFS -> 경우의수를 탐색하는 방법
 * BFS -> 노드와 노드의 관계를 탐색하는 방법
 * <p>
 * grpah[1] = [2,5]
 * graph[2] = [1.3,5]
 * <p>
 * 그래프에서 갈 수 있는 곳을 담는다.
 * <p>
 * 역주행을 생각해본다.
 * boolean[visited] 로 구분
 */
public class BOJ_2606_DFS_BFS_바이러스_2트 {
    static int N;
    static int M;
    static List<List<Integer>> graph = new LinkedList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

/*
        dfs(1);
        System.out.println(Arrays.stream(visited).sum() - 1); // 나 자신 제외
*/
        bfs(1);
//        System.out.println(Arrays.toString(visited));
        System.out.println(Arrays.stream(visited).sum() - 1);
    }

    private static void dfs(int idx) {
        // 종료 조건
        if (idx > N) {
            return;
        }
        // 방문한 곳이면 방문 안하게 하기
        visited[idx] = 1;
        // 조건
        for (Integer nxt : graph.get(idx)) { // 방문할 곳
            if (visited[nxt] != 1) {
                dfs(nxt);
            }
        }
    }

    private static void bfs(int idx) {
        Deque<Integer> q = new LinkedList();
        q.offerLast(idx);
        visited[idx] = 1;

        while (!q.isEmpty()) {
            Integer node = q.pollFirst();
            for (Integer nxt : graph.get(node)) {
                if (visited[nxt] == 1) {
                    continue;
                }
                visited[nxt] = 1;
                q.offerLast(nxt);
            }
        }
    }
}
