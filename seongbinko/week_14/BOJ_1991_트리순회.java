package week_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1991_트리순회 {

    static List<int[]> tree;
    static int N;

    public static void preOrder(int start) {
        if (start != -18) {
            System.out.print((char) (start + 64));
            preOrder(tree.get(start)[0]);
            preOrder(tree.get(start)[1]);
        }
    }

    public static void inOrder(int start) {
        if (start != -18) {
            inOrder(tree.get(start)[0]);
            System.out.print((char) (start + 64));
            inOrder(tree.get(start)[1]);
        }
    }

    public static void postOrder(int start) {
        if (start != -18) {
            postOrder(tree.get(start)[0]);
            postOrder(tree.get(start)[1]);
            System.out.print((char) (start + 64));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            tree.add(new int[]{-18, -18});
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);

            int parent = a - 'A' + 1;
            int leftChild = (b == '.' ? -18 : b - 'A' + 1);
            int rightChild = (c == '.' ? -18 : c - 'A' + 1);

            tree.set(parent, new int[]{leftChild, rightChild});
        }

        preOrder(1);
        System.out.println();
        inOrder(1);
        System.out.println();
        postOrder(1);
    }
}
