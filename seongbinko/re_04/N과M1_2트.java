package re_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class N과M1_2트 {
    static int n;
    static int m;
    static List<int[]> list = new ArrayList<>();
    static List<Integer> arr = new ArrayList<>();
    static boolean[] checks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        checks = new boolean[n + 1];
        recur4(0);
    }

    // 완전탐색 3차원 반복
    private static void exhaustiveSearch() {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    list.add(new int[]{i, j, k});
                }
            }
        }
        for (int[] ints : list) {
            System.out.println(Arrays.toString(ints));
        }
    }

    // 기본 모두 출력
    private static void recur(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            arr.add(depth, i);
            recur(depth + 1);
            arr.remove(depth);
        }
    }

    // 15649 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
    private static void recur2(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!checks[i]) {
                checks[i] = true;
                arr.add(depth, i);
                recur2(depth + 1);
                arr.remove(depth);
                checks[i] = false;
            }
        }
    }

    private static void recur22(int depth) {
        if (depth >= 2 && arr.get(depth - 2) == arr.get(depth - 1)) {
            return;
        }

        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            arr.add(depth, i);
            recur22(depth + 1);
            arr.remove(depth);
        }
    }

    // 15650 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
    // 고른 수열은 오름차순이어야 한다.
    private static void recur3(int depth) {
        if (depth >= 2 && arr.get(depth - 2) >= arr.get(depth - 1)) {
            return;
        }

        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i < n + 1; i++) {

            arr.add(depth, i);
            recur3(depth + 1);
            arr.remove(depth);

        }
    }

    //15651 1부터 N까지 자연수 중에서 M개를 고른 수열
    // 같은 수를 여러 번 골라도 된다.
    private static void recur4(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            arr.add(depth, i);
            recur4(depth + 1);
            arr.remove(depth);
        }
    }
}

