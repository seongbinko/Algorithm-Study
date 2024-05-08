package week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 탑다운 DP로 풀어 본 것을 바텀업 DP,
 * 점화식으로 바꿔보자
 */
public class BOJ_14501_퇴사_바텀업_DP {
    static int N;
    static List<int[]> list = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            list.add(new int[]{t, p});
        }
        dp = new int[N + 1];
//        Arrays.fill(dp, -1);

        for (int index = N - 1; index >= 0; index--) {
            int[] arr = list.get(index);
            if (index + arr[0] <= N) {
                dp[index] = Math.max(dp[index + arr[0]] + arr[1], dp[index + 1]);
            } else {
                dp[index] = dp[index + 1]; // Index Out of Range가 나기 때문에 dp는 N+1 크기로 만들어야 한다.
            }
        }
        System.out.println(dp[0]);
//        System.out.println(Arrays.toString(dp));
    }

    private static int recur(int index) {
        if (index > N) {
            return Integer.MIN_VALUE;
        }
        if (index == N) {
            return 0;
        }
        // 이미 한 번 들름
        if (dp[index] != -1) {
            return dp[index];
        }

        int[] arr = list.get(index);
        int value = Math.max(recur(index + arr[0]) + arr[1], recur(index + 1));
        dp[index] = value;
        return dp[index];
    }
}
