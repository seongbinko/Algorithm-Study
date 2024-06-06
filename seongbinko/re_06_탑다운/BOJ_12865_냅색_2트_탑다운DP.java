package re_06_탑다운;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_12865_냅색_2트_탑다운DP {
    static int N;
    static int W;
    static List<int[]> inputs = new ArrayList<>();

    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        // y x
        dp = new int[N][1000001];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            inputs.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        recur(0, 0);
        System.out.println(dp[0][0]);

    }

    private static int recur(int index, int weight) {

        if (weight > W) {
            return Integer.MIN_VALUE;
        }

        if (index == N) {
            return 0;
        }

        if (dp[index][weight] != -1) {
            return dp[index][weight];
        }
        int[] ints = inputs.get(index);

        dp[index][weight] = Math.max(recur(index + 1, weight + ints[0]) + ints[1], recur(index + 1, weight));
        return dp[index][weight];
    }
}
