package week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2606_DFS_BFS_바이러스 {

    static int n;
    static int m;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        m = Integer.parseInt(br.readLine());
        visited = new int[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 1
            int b = Integer.parseInt(st.nextToken()); // 2
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
//        dfs(1);
        bfs();
        int answer = 0;
        for (int v : visited) {
            answer += v;
        }
        System.out.println(answer - 1);
    }

    private static void dfs(int node) {
        visited[node] = 1;
        for (Integer next : graph.get(node)) {
            // 역주행 및 재방문 방지
            if (visited[next] == 1) {
                continue;
            }
            dfs(next);
        }
    }

    private static void bfs() {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        while (!deque.isEmpty()) {
            int k = deque.pollFirst();
            visited[k] = 1;

            for (int next : graph.get(k)) {
                if (visited[next] == 1) {
                    continue;
                }
                deque.add(next);
            }
        }
    }
}
