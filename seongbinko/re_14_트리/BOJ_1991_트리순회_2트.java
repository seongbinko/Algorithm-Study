package re_14_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1991_트리순회_2트 {
    static int N;
    static List<int[]> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            tree.add(new int[]{-18, -18});
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char A = st.nextToken().charAt(0);
            char B = st.nextToken().charAt(0);
            char C = st.nextToken().charAt(0);

            int parentNode = A - 'A' + 1;
            int leftNode = B - 'A' + 1;
            int rightNode = C - 'A' + 1;

            tree.set(parentNode, new int[]{leftNode, rightNode});
        }

        preOrder(1);
        System.out.println();
        inOrder(1);
        System.out.println();
        postOrder(1);
    }

    private static void preOrder(int index) {
        if (index != -18) {
            System.out.print((char) (index + 'A' - 1));
            for (int nxt : tree.get(index)) {
                preOrder(nxt);
            }
        }
    }

    // 중위 순회 2진 탐색에서 밖에 사용을 못함
    // 노드가 연결 된 곳이 세곳이라면?
    private static void inOrder(int index) {
        if (index != -18) {
            inOrder(tree.get(index)[0]);
            System.out.print((char) (index + 'A' - 1));
            inOrder(tree.get(index)[1]);
        }
    }

    private static void postOrder(int index) {
        if (index != -18) {
            for (int nxt : tree.get(index)) {
                postOrder(nxt);
            }
            System.out.print((char) (index + 'A' - 1));
        }
    }
}
