package week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2961_신맛_쓴맛_짜파구리 {

    static int answer = 999999999;
    static int N;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int shin = Integer.parseInt(st.nextToken());
            int ssen = Integer.parseInt(st.nextToken());
            list.add(new int[]{shin, ssen});
        }

        // 재귀
        recur(0, 1, 0, 0);

        // 쓴맛 단맛의 합중 최소
        System.out.println(answer);
    }

    private static void recur(int index, int shin, int ssen, int use) {
        if (index == N) {
            // 0: 재로를 한번도 사용하지 않았음을 의미.
            if (use != 0) {
                answer = Math.min(answer, Math.abs(shin - ssen));
            }
            return;
        }
        // 재료를 넣는다
        recur(index + 1, shin * list.get(index)[0], ssen + list.get(index)[1], use + 1);
        // 재료를 넣지 않는다.
        recur(index + 1, shin, ssen, use);

    }
}
