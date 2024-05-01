package week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15656_N과M7 {

    static int N;
    static int M;
    static int[] num;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        num = new int[N]; // [9,8,7,1]
        arr = new int[M]; // 수를 담을 곳 [1,7]
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        recur(0);
        System.out.println(sb);
    }

    private static void recur(int depth) {
        // 종료 조건 만들기
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        // 숫자 담기
        for (int i = 0; i < num.length; i++) {
            arr[depth] = num[i];
            recur(depth + 1);
        }
    }
}
