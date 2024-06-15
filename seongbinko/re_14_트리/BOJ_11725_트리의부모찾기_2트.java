package re_14_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기_2트 {

    static List<List<Integer>> graph;
    static int[] parent; // 부모노드의 번호
    static int[] depth; // 깊이
    static int[] childCnt; // 자식의 갯수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        parent = new int[n + 1];
        depth = new int[n + 1];
        childCnt = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 양방향 연결
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(1, 0);

        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(depth));
        System.out.println(Arrays.toString(childCnt));
    }

    private static void dfs(int node, int prev) {
        parent[node] = prev; // 내 부모 기록
        depth[node] = depth[prev] + 1; // 나의 depth
        for (Integer nxt : graph.get(node)) {
            if (nxt == prev) {
                continue;
            }
            dfs(nxt, node);
        }
        childCnt[prev]++; // 자식의 갯수
    }
}

