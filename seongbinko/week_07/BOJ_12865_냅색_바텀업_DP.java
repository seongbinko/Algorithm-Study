package week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_12865_냅색_바텀업_DP {
    static int n;
    static int w;
    static List<int[]> list = new ArrayList<>();
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 물건 수
        w = Integer.parseInt(st.nextToken()); // 베낭 무게
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}); // weight, value
        }

        dp = new int[n + 1][w + 1];
        for (int y = 1; y <= n; y++) {
            int[] ints = list.get(y - 1);
            int weight = ints[0];
            int value = ints[1];

            for (int x = 1; x <= w; x++) {
                if (x < weight) {
                    dp[y][x] = dp[y - 1][x];
                } else {
                    dp[y][x] = Math.max(dp[y - 1][x], dp[y - 1][x - weight] + value);
                }
            }
        }

        System.out.println(dp[n][w]);
    }
}
