package re_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2961_백트래킹_경우의수_2트 {

    static int N;
    static List<int[]> inputs = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            inputs.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        // 신맛과 쓴맛의 차이
        combine(0, 1, 0, 0);
        System.out.println(answer);
    }

    private static void combine(int index, int shin, int ssen, int size) {
        // 1. 조건
        // 재료를 쓰지 않는 것은 요리라고 볼 수 없다!
        // index == N 안으로 넣는것이 더 효율적이다, 왜냐면 N에 도달했을때 무엇을쓰고 안쓰는지가 명확
        if (size > 0) {
            answer = Math.min(answer, Math.abs(shin - ssen));
        }
        // 2. 종료조건
        if (index == N) {
            return;
        }
        // 3. 재귀
        int[] jr = inputs.get(index);
        //1. 재료를 쓴다
        combine(index + 1, shin * jr[0], ssen + jr[1], size + 1);

        //2. 재료를 안쓴다.
        combine(index + 1, shin, ssen, size);

    }
}
