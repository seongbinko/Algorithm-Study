package re_05_경우의수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_19942_요리사복잡한고민_2트 {
    static int N;
    static List<int[]> inputs = new ArrayList<>();
    static int[] goal;
    static int min = Integer.MAX_VALUE;
    static String answer = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        goal = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            goal[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            inputs.add(
                    new int[]{
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken())
                    }
            );
        }

        // 최소 비용 출력
        // 최소 비용 식재료 번호 (I)
        // 답이 없다면 -1, 둘째줄에는 아무것도 출력 x
        // 식재료 번호는 1부터 시작
        combine(0, 0, 0, 0, 0, 0, new int[N]);

        if (min == Integer.MAX_VALUE || answer == null) {
            System.out.println(-1);
        } else {
            System.out.println(min);
            System.out.println(answer);
        }
    }

    private static void combine(int index, int p, int f, int s, int v, int c, int[] uses) {
        if (p >= goal[0] && f >= goal[1] && s >= goal[2] && v >= goal[3]) {
            if (min > c) {
                min = c;

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < uses.length; i++) {
                    if (uses[i] == 1) {
                        sb.append(i + 1);
                        sb.append(" ");
                    }
                }
                answer = sb.toString();
            }
        }
        // 종료 조건
        if (index == N) {
            return;
        }
        int[] ints = inputs.get(index);
        // 1. 재료를 사용한다.
        uses[index] = 1;
        combine(index + 1, p + ints[0], f + ints[1], s + ints[2], v + ints[3], c + ints[4], uses);
        uses[index] = 0;
        // 2. 재료를 사용하지 않는다.
        combine(index + 1, p, f, s, v, c, uses);
    }
}
