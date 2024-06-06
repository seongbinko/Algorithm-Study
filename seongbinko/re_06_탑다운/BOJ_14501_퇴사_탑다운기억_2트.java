package re_06_탑다운;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


// https://www.inflearn.com/questions/1035854/12865
public class BOJ_14501_퇴사_탑다운기억_2트 {
    static int N;
    static List<int[]> inputs = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;

    static int[] dp; // 기억할 테이블

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        Arrays.fill(dp, -1);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            inputs.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        consult(0);
        System.out.println(dp[0]);

    }

    private static int consult(int index) {
        if (index == N) {
            return 0;
        }
        if (index > N) {
            return Integer.MIN_VALUE;
        }
        // 이미 저장되어 있다
        if (dp[index] != -1) {
            return dp[index];
        }

        int[] consult = inputs.get(index);
        // 상담을 받거나 안받거나 그 중에서 더 많은 돈을 버는 경우를 dp 테이블에 저장한다.
        // 끝쪽에서 생각하기
        // 0 + 상담받은 돈 +10
        dp[index] = Math.max(consult(index + consult[0]) + consult[1], consult(index + 1));

        return dp[index];
    }
}
