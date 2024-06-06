package re_05_경우의수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사_2트 {
    static int N;
    static List<int[]> inputs = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            inputs.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        consult(0, 0);
        System.out.println(answer);

    }

    private static void consult(int index, int money) {
        if (index == N) {
            answer = Math.max(answer, money);
            return;
        }

        int[] ints = inputs.get(index);
        // 1. 한다
        if (index + ints[0] <= N) {
            consult(index + ints[0], money + ints[1]);
        }
        // 2. 안한다
        consult(index + 1, money);
    }

    private static void consult2(int index, int money) {
        if (index == N) {
            answer = Math.max(answer, money);
            return;
        }
        if (index > N) {
            return;
        }

        int[] ints = inputs.get(index);
        // 1. 한다
        consult(index + ints[0], money + ints[1]);

        // 2. 안한다
        consult(index + 1, money);
    }
}
