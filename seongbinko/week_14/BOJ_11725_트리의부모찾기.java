package week_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기 {

    static List<List<Integer>> relation;
    static int[] parent;
    static int[] depth;
    static int[] childNum;

    public static void dfs(int node, int prv) {
        for (int nxt : relation.get(node)) {
            if (nxt == prv) {
                continue;
            }

            parent[nxt] = node;
            depth[nxt] = depth[node] + 1;
            dfs(nxt, node);
            childNum[node] += childNum[nxt];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        relation = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            relation.add(new ArrayList<>());
        }

        parent = new int[n + 1];
        depth = new int[n + 1];
        childNum = new int[n + 1];
        Arrays.fill(childNum, 1);

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relation.get(a).add(b);
            relation.get(b).add(a);
        }

        // Perform DFS starting from node 1, with no parent (0)
        dfs(1, 0);

        // Print the parent of each node starting from node 2
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
}

