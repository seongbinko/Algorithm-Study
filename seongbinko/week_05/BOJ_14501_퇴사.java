package week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {

    static int N;
    static List<int[]> list = new ArrayList<>();
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            list.add(new int[]{t, p});
        }
        recur2(0, 0);
        System.out.println(answer);
    }

    private static void recur(int index, int p) {
        if (index == N - 1) {
            answer = Math.max(answer, p);
            return;
        }
        int[] arr = list.get(index);
        // 상담 한다
        if (index + arr[0] <= N) {
            recur(index + arr[0], p + arr[1]);
        }
        // 상담하지 않는다.
        recur(index + 1, p);
    }

    private static void recur2(int index, int p) {
        if (index == N) {
            answer = Math.max(answer, p);
            return;
        }
        if (index > N) {
            return;
        }

        int[] arr = list.get(index);
        // 상담 한다
        recur2(index + arr[0], p + arr[1]);

        // 상담하지 않는다.
        recur2(index + 1, p);
    }
}
