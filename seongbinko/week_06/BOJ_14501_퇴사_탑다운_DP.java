package week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 탑다운: 뒤에서 부터 정해서 오는 방식
 */
public class BOJ_14501_퇴사_탑다운_DP {
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
        dp = new int[N];
        Arrays.fill(dp, -1);

        int answer = recur(0);
        System.out.println(answer);
        System.out.println(Arrays.toString(dp));
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
