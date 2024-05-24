package week_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1197_최소스패닝트리_프림 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new int[]{C, B});
            graph.get(B).add(new int[]{C, A});
        }

        boolean[] visited = new boolean[N + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 1});

        int answer = 0;
        int cnt = 0;

        while (!pq.isEmpty()) {
            if (cnt == N) {
                break;
            }

            int[] current = pq.poll();
            int weight = current[0];
            int node = current[1];

            if (!visited[node]) {
                visited[node] = true;
                answer += weight;
                cnt++;

                for (int[] next : graph.get(node)) {
                    if (!visited[next[1]]) {
                        pq.add(next);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}

