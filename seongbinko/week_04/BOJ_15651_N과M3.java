package week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651_N과M3 {

    static int N;
    static int M;
    static int[] arr;
    // 시간 초과, StringBuilder 를 사용하자
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N=4, M=2 [1,4]
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        recur(0);
        System.out.print(sb);
    }

    private static void recur(int depth) {
        // 종료 조건
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        // 재귀 로직
        for (int i = 0; i < N; i++) {
            arr[depth] = i + 1;
            recur(depth + 1);
        }
    }
}
