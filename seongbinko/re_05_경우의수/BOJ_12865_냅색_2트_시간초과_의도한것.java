package re_05_경우의수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_12865_냅색_2트_시간초과_의도한것 {
    static int N;
    static int W;
    static List<int[]> inputs = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            inputs.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        hanggun(0, 0, 0);
        System.out.println(answer);

    }

    private static void hanggun(int index, int w, int v) {

        if (w > W) {
            return;
        }

        if (index == N) {
            answer = Math.max(answer, v);
            return;
        }
        int[] ints = inputs.get(index);
        // 가방에 물건을 넣는다.
        hanggun(index + 1, w + ints[0], v + ints[1]);

        // 넣지 않는다.
        hanggun(index + 1, w, v);
    }
}
